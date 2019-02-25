package ahmed.fciibrahem.helwan.edu.eg.moviesapp;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static ahmed.fciibrahem.helwan.edu.eg.moviesapp.MainActivity.movie;

public class MovieFeatchData extends AsyncTask<String, Void, String>  {
     AsyncTaskCompleteListener callback;

    static String Data;
    List<Movie> MoviesData=new ArrayList();


    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            final String API_KEY_PARAM = "api_key";
            final String PAGE_PARAM = "page";
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("http")
                    .authority("api.themoviedb.org")
                    .appendPath("3")
                    .appendPath("movie")
                    .appendPath(strings[0])
                    .appendQueryParameter(API_KEY_PARAM, "09ef905fb0a8f078de853a6aa6ac8983");

            URL url = new URL(builder.toString());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");

            }
            Data = buffer.toString();
            Log.i("Data", Data + "");


            Log.i("url", "" + url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




        return Data;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
            if (Data != null) {
                try {
                JSONObject Movies = new JSONObject(Data);
                JSONArray MoviesArray = Movies.getJSONArray("results");
                for (int x = 0; x < MoviesArray.length(); x++) {
                    Movie movie = new Movie();

                    movie.setPosterImage(MoviesArray.getJSONObject(x).get("poster_path").toString());
                    movie.setTitile(MoviesArray.getJSONObject(x).get("original_title").toString());
                    movie.setVoteAvrage(MoviesArray.getJSONObject(x).get("vote_average").toString());
                    movie.setReleaseDate(MoviesArray.getJSONObject(x).get("release_date").toString());
                    movie.setOverview(MoviesArray.getJSONObject(x).get("overview").toString());
                    MoviesData.add(movie);


                    Log.i("onss", "" + movie.getTitile().toString());


                }}

             catch(JSONException e){
                e.printStackTrace();
            }

            callback.onTaskComplete(MoviesData);
        }
    }}





package ahmed.fciibrahem.helwan.edu.eg.moviesapp;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

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
import java.util.jar.JarEntry;


public class MainActivity extends AppCompatActivity implements AsyncTaskCompleteListener {
    static String Data = "";
   static List<Movie> MoviesData = new ArrayList();
    static Movie movie =new Movie();
    Context context;
    RecyclerView recyclerView;
    MovieFeatchData fetch = new MovieFeatchData();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.mostPopular)
        {
            MovieFeatchData pop=new MovieFeatchData();
            pop.callback=this;
            pop.execute("popular");
        }
        else if(item.getItemId()==R.id.topRated)
        {
            MovieFeatchData top=new MovieFeatchData();
            top.callback=this;

            top.execute("top_rated");
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recy);
        fetch.callback=this;
        fetch.execute("popular");

    }



    @Override
    public List<Movie> onTaskComplete(List<Movie> Movies) {
        MovieAdpter adapter = new MovieAdpter(Movies,this);
        RecyclerView.LayoutManager  manager= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        MoviesData=Movies;
        Log.i("hiii", "onTaskComplete: "+MoviesData.size());
        return null;
    }
}






package ahmed.fciibrahem.helwan.edu.eg.moviesapp;

import org.json.JSONException;

import java.util.List;

interface AsyncTaskCompleteListener {
    public List<Movie> onTaskComplete(List<Movie> Movies) ;

}

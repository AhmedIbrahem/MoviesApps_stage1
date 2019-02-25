package ahmed.fciibrahem.helwan.edu.eg.moviesapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Movie   {

    private String Titile;
    private String PosterImage;
    private  String Overview;
    private String voteAvrage;
    private String ReleaseDate;


    public void setTitile(String titile) {
        Titile = titile;
    }

    public void setPosterImage(String posterImage) {
        PosterImage = posterImage;
    }

    public void setOverview(String overview) {
        Overview = overview;
    }

    public void setVoteAvrage(String voteAvrage) {
        this.voteAvrage = voteAvrage;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getTitile() {
        return Titile;
    }

    public String getPosterImage() {
        return PosterImage;
    }

    public String getOverview() {
        return Overview;
    }

    public String getVoteAvrage() {
        return voteAvrage;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }


}

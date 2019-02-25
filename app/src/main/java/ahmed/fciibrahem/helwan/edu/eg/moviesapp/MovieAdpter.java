package ahmed.fciibrahem.helwan.edu.eg.moviesapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdpter extends RecyclerView.Adapter<MovieAdpter.MovieHolder>{
    List<Movie> MovieList;
    Movie movie;
    Context context;
    public MovieAdpter(List<Movie> movieList, Context context)
    {
        this.MovieList = movieList;
        this.context = context;
    }
    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         View row = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclar_item, viewGroup, false);
        MovieHolder holder = new MovieHolder(row);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder indianMovieHolder, int posation) {
        movie = MovieList.get(posation);
        Picasso.with(context).load("http://image.tmdb.org/t/p/w185/"+movie.getPosterImage()).into(indianMovieHolder.Poster);


    }

    @Override
    public int getItemCount() {
        return MovieList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {
        TextView Title, Rate, Story;
        ImageView Poster;


        public MovieHolder(@NonNull final View itemView) {
            super(itemView);
            Poster = (ImageView) itemView.findViewById(R.id.Movie_poster);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int posatin=getAdapterPosition();
                    Movie indinMovies= MovieList.get(getAdapterPosition());
                    Toast.makeText(context,""+indinMovies.getTitile(), Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(context,DetailsActivity.class);
                    String Movie_title=indinMovies.getTitile();
                    String Movie_Poster=indinMovies.getPosterImage();
                    String Movie_relaseDate=indinMovies.getReleaseDate();
                    String Movie_voteavrage=indinMovies.getVoteAvrage();
                    String Movie_overview=indinMovies.getOverview();
                    Bundle bundle=new Bundle();
                    bundle.putString("title",Movie_title);
                    bundle.putString("poster",Movie_Poster);
                    bundle.putString("relasedate",Movie_relaseDate);
                    bundle.putString("vot",Movie_voteavrage);
                    bundle.putString("over",Movie_overview);
                    intent.putExtras(bundle);
                    context.startActivity(intent);





                }
            });
        }
    }
}

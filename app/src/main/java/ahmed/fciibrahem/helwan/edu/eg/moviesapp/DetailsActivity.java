package ahmed.fciibrahem.helwan.edu.eg.moviesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
ImageView poster;
TextView Title,Overview,Relsedata,Voteavrage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        poster=findViewById(R.id.poster);
        Title=findViewById(R.id.Movie_title);
        Overview=findViewById(R.id.overview);
        Relsedata=findViewById(R.id.relaseDate);
        Voteavrage=findViewById(R.id.voteavrage);
        Movie movie=new Movie();
        Bundle bundle=getIntent().getExtras();
        Title.setText(bundle.getString("title"));
        Overview.setText(bundle.getString("over"));
        Relsedata.setText(bundle.getString("relasedate"));
        Voteavrage.setText(bundle.getString("vot"));
        Picasso.with(this).load("http://image.tmdb.org/t/p/w185/"+bundle.getString("poster")).resize(190,100).into(poster);



    }
}

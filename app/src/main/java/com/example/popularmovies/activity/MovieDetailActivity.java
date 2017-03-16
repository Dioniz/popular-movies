package com.example.popularmovies.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.popularmovies.datamodel.DataModel;
import com.example.popularmovies.datamodel.searchResult.SearchResultMovie;
import com.example.popularmovies.network.Client;
import com.example.popularmovies.popularmovies.R;
import com.squareup.picasso.Picasso;


public class MovieDetailActivity extends AppCompatActivity {
    private int mMoviePosition;
    private SearchResultMovie mSearchResultMovie;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        Intent intent = getIntent();
        mMoviePosition = intent.getIntExtra(MainActivity.POSITION_KEY,0);

        mSearchResultMovie = DataModel.getInstance().getSearchResultMovie();

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(mSearchResultMovie.getResults().get(mMoviePosition).getTitle());

        loadData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadData() {
        //Backdrop
        final ImageView backdropImageView = (ImageView) findViewById(R.id.backdrop);
        Picasso.with(this).load(Client.BASE_IMAGE_URL + mSearchResultMovie.getResults().get(mMoviePosition).getPosterPath()).into(backdropImageView);

        //Movie Data
        final TextView yearTextView = (TextView) findViewById(R.id.tv_year);
        final TextView overviewTextView = (TextView) findViewById(R.id.tv_overview);
        yearTextView.setText(mSearchResultMovie.getResults().get(mMoviePosition).getReleaseDate().split("-")[0]);
        overviewTextView.setText(mSearchResultMovie.getResults().get(mMoviePosition).getOverview());
    }
}

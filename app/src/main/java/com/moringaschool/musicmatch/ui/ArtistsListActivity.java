package com.moringaschool.musicmatch.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.moringaschool.musicmatch.adapters.TrackListAdapter;
import com.moringaschool.musicmatch.network.Constants;
import com.moringaschool.musicmatch.R;
import com.moringaschool.musicmatch.models.Track;
import com.moringaschool.musicmatch.models.TrackSearchResponse;
import com.moringaschool.musicmatch.network.MusicMatchApi;
import com.moringaschool.musicmatch.network.MusicMatchClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistsListActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private TrackListAdapter mAdapter;
    @BindView(R.id.errorTextView)
    TextView mErrorTextView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    public static final String TAG = ArtistsListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);
        ButterKnife.bind(this);

//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String Artists = ((TextView)view).getText().toString();
//                Log.d("ArtistsActivity.this", "ONITEMCLICK");
//                Toast.makeText(ArtistsActivity.this, Artists, Toast.LENGTH_LONG).show();
//            }
//        });

        Intent intent = getIntent();
        String artist = intent.getStringExtra("artist");
//        mLocationTextView.setText("Here are the top ten songs of: " + artist);


        MusicMatchApi client = MusicMatchClient.getClient();

        Call<TrackSearchResponse> call = client.getTracks(Constants.API_KEY, artist);

        call.enqueue(new Callback<TrackSearchResponse>() {
            @Override
            public void onResponse(Call<TrackSearchResponse> call, Response<TrackSearchResponse> response) {

                hideProgressBar();
                if(response.isSuccessful()){
                    List<Track> tracks = response.body().getMessage().getBody().getTrackList();
                    Log.d(TAG, String.format("Track Size %d", tracks.size()));
                    mAdapter = new TrackListAdapter(ArtistsListActivity.this, tracks);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(ArtistsListActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                }
                else{
                    showFailureMessage();
                }
            }

            @Override
            public void onFailure(Call<TrackSearchResponse> call, Throwable t) {
                Log.d(TAG, t.getMessage());
                hideProgressBar();
                showFailureMessage();
            }

        });
    };
    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

}


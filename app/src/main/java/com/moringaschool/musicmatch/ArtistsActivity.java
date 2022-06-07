package com.moringaschool.musicmatch;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistsActivity extends AppCompatActivity {

    @BindView(R.id.locationTextView)
    TextView mLocationTextView;
    @BindView(R.id.listView)
    ListView mListView;
    public static final String TAG = ArtistsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);
        ButterKnife.bind(this);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Artists = ((TextView)view).getText().toString();
                Log.d("ArtistsActivity.this", "ONITEMCLICK");
                Toast.makeText(ArtistsActivity.this, Artists, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String artist = intent.getStringExtra("artist");
        mLocationTextView.setText("Here are the top ten songs of: " + artist);


        MusicMatchApi client = MusicMatchClient.getClient();

        Call<TrackSearchResponse> call = client.getTracks(Constants.API_KEY, artist);

        call.enqueue(new Callback<TrackSearchResponse>() {
            @Override
            public void onResponse(Call<TrackSearchResponse> call, Response<TrackSearchResponse> response) {

                    List<Track> tracks = response.body().getMessage().getBody().getTrackList();
                    Log.d(TAG, String.format("Track Size %d", tracks.size()));
                    ArrayAdapter adapter
                            = new ArtistsArrayAdapter(ArtistsActivity.this, android.R.layout.simple_list_item_1, tracks);
                    mListView.setAdapter(adapter);
                }
            @Override
            public void onFailure(Call<TrackSearchResponse> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }

        });
    };

}


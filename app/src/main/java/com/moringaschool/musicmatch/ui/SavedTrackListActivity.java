package com.moringaschool.musicmatch.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.musicmatch.R;
import com.moringaschool.musicmatch.adapters.FirebaseTrackViewHolder;
import com.moringaschool.musicmatch.models.Track;
import com.moringaschool.musicmatch.network.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedTrackListActivity extends AppCompatActivity {
    private DatabaseReference mTrackReference;
    private FirebaseRecyclerAdapter<Track, FirebaseTrackViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView)
    TextView mErrorTextView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);
        ButterKnife.bind(this);

        mTrackReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_TRACKS);
        setUpFirebaseAdapter();
        hideProgressBar();
        showRestaurants();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Track> options =
                new FirebaseRecyclerOptions.Builder<Track>()
                        .setQuery(mTrackReference, Track.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Track, FirebaseTrackViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseTrackViewHolder firebaseRestaurantViewHolder, int position, @NonNull Track track) {
                firebaseRestaurantViewHolder.bindTrack(track);
            }

            @NonNull
            @Override
            public FirebaseTrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_list_item, parent, false);
                return new FirebaseTrackViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }

    private void showRestaurants() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
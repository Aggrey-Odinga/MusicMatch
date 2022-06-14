package com.moringaschool.musicmatch.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.musicmatch.R;
import com.moringaschool.musicmatch.network.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DatabaseReference mSearchedArtistReference;
    private ValueEventListener mSearchedArtistReferenceListener;

    @BindView(R.id.artistEditText)
    EditText martistEditText;
    @BindView(R.id.buttontoptenartists)
    Button mButtontoptenartists;
    @BindView(R.id.savedSongbtn)
    Button mSavedTracksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mSearchedArtistReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_ARTIST);

        mSearchedArtistReferenceListener = mSearchedArtistReference.addValueEventListener(new ValueEventListener() { //attach listener
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) { //something changed!
                for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()) {
                    String artist = artistSnapshot.getValue().toString();
                    Log.d("Artists update", "artist: " + artist); //log
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { //update UI here if error occurred.

            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mButtontoptenartists.setOnClickListener(this);
        mSavedTracksButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v ==  mButtontoptenartists){
            String artist = martistEditText.getText().toString();
            saveArtistToFirebase(artist);
            Intent intent = new Intent(MainActivity.this, ArtistsListActivity.class);
            intent.putExtra("artist", artist);
            startActivity(intent);
        }
        if (v == mSavedTracksButton){
            Intent intent = new Intent(MainActivity.this, SavedTrackListActivity.class);
            startActivity(intent);
        }
    }
    public void saveArtistToFirebase(String artist) {
        mSearchedArtistReference.push().setValue(artist);
    }
    public void onLaunchWebPagebuttonClicked (View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/musixmatch/musixmatch-sdk"));
        startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearchedArtistReference.removeEventListener(mSearchedArtistReferenceListener);
    }
}

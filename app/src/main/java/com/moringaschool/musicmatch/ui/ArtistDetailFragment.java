package com.moringaschool.musicmatch.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.musicmatch.R;
import com.moringaschool.musicmatch.models.Track;
import com.moringaschool.musicmatch.network.Constants;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtistDetailFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.trackImageView)
    ImageView mImageLabel;
    @BindView(R.id.artistNameTextView)
    TextView mNameLabel;
    @BindView(R.id.trackTextView)
    TextView mArtistTextView;
    @BindView(R.id.saveTrackButton)
    Button  mSaveTrackButton;
    @BindView(R.id.albumTextView2)
    TextView mAlbumTextView;
    @BindView(R.id.websiteTextView)
    TextView mWebsiteTextView;


    private Track mTrack;

    public ArtistDetailFragment() {
        // Required empty public constructor
    }


    public static ArtistDetailFragment newInstance(Track artist) {
        ArtistDetailFragment artistDetailFragment = new ArtistDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("artist", Parcels.wrap(artist));
        artistDetailFragment.setArguments(args);
        return artistDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mTrack = Parcels.unwrap(getArguments().getParcelable("artist"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_artist_detail, container, false);
        ButterKnife.bind(this, view);

        mNameLabel.setText(mTrack.getTrack().getTrackName());
        mArtistTextView.setText(mTrack.getTrack().getArtistName());
        mAlbumTextView.setOnClickListener(this);
        mWebsiteTextView.setOnClickListener(this);
        mSaveTrackButton.setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View view) {
        if (view == mSaveTrackButton) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();
            DatabaseReference trackRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_TRACKS)
                    .child(uid);

            DatabaseReference pushRef = trackRef.push();
            String pushId = pushRef.getKey();
            mTrack.setPushId(pushId);
            pushRef.setValue(mTrack);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
        if(view == mAlbumTextView){
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mTrack.getTrack().getTrackShareUrl()));
            startActivity(webIntent);
        }
        if(view == mWebsiteTextView){
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mTrack.getTrack().getTrackEditUrl()));
            startActivity(webIntent);
        }
    }

}
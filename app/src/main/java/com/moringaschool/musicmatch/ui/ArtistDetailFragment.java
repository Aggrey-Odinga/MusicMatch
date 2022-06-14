package com.moringaschool.musicmatch.ui;

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
    @BindView(R.id.saveTrackButton)
    Button  mSaveTrackButton;

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

        mSaveTrackButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == mSaveTrackButton) {
            DatabaseReference trackRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_TRACKS);
            trackRef.push().setValue(mTrack);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }

}
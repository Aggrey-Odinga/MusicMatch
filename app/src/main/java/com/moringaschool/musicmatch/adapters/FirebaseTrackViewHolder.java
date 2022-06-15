package com.moringaschool.musicmatch.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.musicmatch.R;
import com.moringaschool.musicmatch.models.Track;
import com.moringaschool.musicmatch.network.Constants;
import com.moringaschool.musicmatch.ui.ArtistDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseTrackViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;

    public FirebaseTrackViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindTrack(Track track) {
        ImageView artistImageView = (ImageView) mView.findViewById(R.id.artistImageView);
        TextView nameTextView = (TextView) mView.findViewById(R.id.artistNameTextView);
        TextView trackTextView = (TextView) mView.findViewById(R.id.trackTextView);


        nameTextView.setText(track.getTrack().getTrackName());
        trackTextView.setText(track.getTrack().getArtistName());
        }

    @Override
    public void onClick(View view) {
        final ArrayList<Track> tracks = new ArrayList<>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_TRACKS).child(uid);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    tracks.add(snapshot.getValue(Track.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, ArtistDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("tracks", Parcels.wrap(tracks));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
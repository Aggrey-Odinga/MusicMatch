package com.moringaschool.musicmatch.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.musicmatch.R;
import com.moringaschool.musicmatch.models.Track;
import com.moringaschool.musicmatch.ui.ArtistDetailActivity;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrackListAdapter extends RecyclerView.Adapter<TrackListAdapter.TrackViewHolder> {
    private List<Track> mTracks;
    private Context mContext;

    public TrackListAdapter(Context context, List<Track> tracks){
        mContext = context;
        mTracks = tracks;
    }
    @Override
    public TrackListAdapter.TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_list_item, parent, false);
        TrackViewHolder viewHolder = new TrackViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TrackListAdapter.TrackViewHolder holder, int position) {
        holder.bindTrack(mTracks.get(position));
    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }
    public class TrackViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        @BindView(R.id.artistImageView)
        ImageView mArtistImageView;
        @BindView(R.id.artistNameTextView)
        TextView mNameTextView;
        @BindView(R.id.trackTextView)
        TextView mTrackTextView;


        private Context mContext;

        public TrackViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, ArtistDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("tracks", Parcels.wrap(mTracks));
            mContext.startActivity(intent);
        }
        public void bindTrack(Track track) {
            mNameTextView.setText(track.getTrack().getArtistName());
            mTrackTextView.setText(track.getTrack().getTrackName());
        }
    }
}

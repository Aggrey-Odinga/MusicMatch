package com.moringaschool.musicmatch;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.moringaschool.musicmatch.models.Track;

import java.util.List;

public class ArtistsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private List<Track> mTracks;


    public ArtistsArrayAdapter(Context mContext, int resource, List<Track> mTracks){
        super(mContext, resource);
        this.mContext = mContext;
        this.mTracks = mTracks;

    }
    @Override
    public Object getItem(int position){
        Track track = mTracks.get(position);
        return String.format("%s \nName of Track: %s", track.getTrack().getArtistName(), track.getTrack().getTrackName());
    }

    @Override
    public int getCount() {
        return mTracks.size();
    }
}

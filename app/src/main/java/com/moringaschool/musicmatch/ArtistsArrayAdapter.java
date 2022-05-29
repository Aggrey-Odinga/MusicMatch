package com.moringaschool.musicmatch;

import android.content.Context;
import android.widget.ArrayAdapter;

public class ArtistsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mArtists;
    private String[] mSongs;

    public ArtistsArrayAdapter(Context mContext, int resource, String[] mArtists, String[] mSongs){
        super(mContext, resource);
        this.mContext = mContext;
        this.mArtists = mArtists;
        this.mSongs = mSongs;
    }
    @Override
    public Object getItem(int position){
        String Artists = mArtists[position];
        String Songs = mSongs[position];
        return String.format("%s \nGreatest Hit: %s", Artists, Songs);
    }

    @Override
    public int getCount() {
        return mArtists.length;
    }
}

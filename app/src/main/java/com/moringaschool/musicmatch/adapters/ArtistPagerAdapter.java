package com.moringaschool.musicmatch.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.musicmatch.models.Track;
import com.moringaschool.musicmatch.ui.ArtistDetailFragment;

import java.util.List;

public class ArtistPagerAdapter extends FragmentPagerAdapter {
    private List<Track> mTracks;

    public ArtistPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Track> tracks) {
        super(fm, behavior);
        mTracks = tracks;
    }
    @Override
    public Fragment getItem(int position) {
        return ArtistDetailFragment.newInstance(mTracks.get(position));
    }
    @Override
    public int getCount() {
        return mTracks.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mTracks.get(position).getTrack().getAlbumName();
    }
}

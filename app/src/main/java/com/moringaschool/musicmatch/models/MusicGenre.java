
package com.moringaschool.musicmatch.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class MusicGenre {

    @SerializedName("music_genre")
    @Expose
    private MusicGenre__1 musicGenre;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MusicGenre() {
    }

    /**
     * 
     * @param musicGenre
     */
    public MusicGenre(MusicGenre__1 musicGenre) {
        super();
        this.musicGenre = musicGenre;
    }

    public MusicGenre__1 getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(MusicGenre__1 musicGenre) {
        this.musicGenre = musicGenre;
    }

}

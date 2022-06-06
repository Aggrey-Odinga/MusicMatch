
package com.moringaschool.musicmatch;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("track")
    @Expose
    private Track__1 track;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Track() {
    }

    /**
     * 
     * @param track
     */
    public Track(Track__1 track) {
        super();
        this.track = track;
    }

    public Track__1 getTrack() {
        return track;
    }

    public void setTrack(Track__1 track) {
        this.track = track;
    }

}

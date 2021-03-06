
package com.moringaschool.musicmatch.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Track {

    @SerializedName("track")
    @Expose
    private Track__1 track;

    private String pushId;
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
    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

}

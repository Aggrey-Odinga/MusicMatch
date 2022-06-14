
package com.moringaschool.musicmatch.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.musicmatch.models.Message;

import org.parceler.Parcel;

@Parcel
public class TrackSearchResponse {

    @SerializedName("message")
    @Expose
    private Message message;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TrackSearchResponse() {
    }

    /**
     * 
     * @param message
     */
    public TrackSearchResponse(Message message) {
        super();
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

}

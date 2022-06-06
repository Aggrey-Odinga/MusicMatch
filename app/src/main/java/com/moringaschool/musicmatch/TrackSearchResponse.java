
package com.moringaschool.musicmatch;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


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

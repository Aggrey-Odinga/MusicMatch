package com.moringaschool.musicmatch.network;

import com.moringaschool.musicmatch.models.TrackSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MusicMatchApi {
    @GET("track.search")
    Call<TrackSearchResponse> getTracks(
            @Query("apikey") String apikey,
           @Query("q_artist") String artist
    );
}

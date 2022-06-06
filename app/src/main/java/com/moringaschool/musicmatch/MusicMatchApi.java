package com.moringaschool.musicmatch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MusicMatchApi {
    @GET("track.search")
    Call<TrackSearchResponse> getTracks(
            @Query("artist") String artist
    );
}

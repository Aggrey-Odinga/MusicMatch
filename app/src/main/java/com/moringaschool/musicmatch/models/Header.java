
package com.moringaschool.musicmatch.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Header {

    @SerializedName("status_code")
    @Expose
    private Integer statusCode;
    @SerializedName("execute_time")
    @Expose
    private Double executeTime;
    @SerializedName("available")
    @Expose
    private Integer available;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Header() {
    }

    /**
     * 
     * @param available
     * @param statusCode
     * @param executeTime
     */
    public Header(Integer statusCode, Double executeTime, Integer available) {
        super();
        this.statusCode = statusCode;
        this.executeTime = executeTime;
        this.available = available;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Double getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Double executeTime) {
        this.executeTime = executeTime;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

}

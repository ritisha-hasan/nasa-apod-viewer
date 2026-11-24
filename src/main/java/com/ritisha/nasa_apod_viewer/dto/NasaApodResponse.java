package com.ritisha.nasa_apod_viewer.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class NasaApodResponse {
    private String date;
    private String title;
    private String explanation;
    private String url;

    @JsonProperty("media_type")
    private String media_type;

    protected NasaApodResponse() {}

    public NasaApodResponse(String date, String title, String explanation, String url, String media_type) {
        this.date = date;
        this.title = title;
        this.explanation = explanation;
        this.url = url;
        this.media_type = media_type;
    }
}
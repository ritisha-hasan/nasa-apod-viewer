package com.ritisha.nasa_apod_viewer.service;

import com.ritisha.nasa_apod_viewer.dto.NasaApodResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

//generic Spring-managed bean
@Component
public class NasaApiClient {
    private final RestClient restClient;

    //pulls value from application.properties and injects automatically
    @Value("${nasa.api.key}")
    private String apiKey;

    public NasaApiClient(@Value("${nasa.api.key}") String apiKey) {
        this.apiKey = apiKey;
        //builds a reusable HTTP client that points at the NASA base url
        this.restClient = RestClient.builder()
                .baseUrl("https://api.nasa.gov/planetary/apod")
                .build();
    }

    public NasaApodResponse fetchTodayApod() {
        //outbound call
        //builds get request, adds api_key param, sends + converts the JSON body into a NasaApodResponse object
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("api_key", apiKey)
                        .build())
                .retrieve()
                .body(NasaApodResponse.class);
    }
}
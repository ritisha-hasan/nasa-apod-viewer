package com.ritisha.nasa_apod_viewer.service;

import com.ritisha.nasa_apod_viewer.dto.NasaApodResponse;
import com.ritisha.nasa_apod_viewer.entity.ApodEntry;
import com.ritisha.nasa_apod_viewer.repository.ApodRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class ApodService {
    private final ApodRepository apodRepository;
    private final NasaApiClient nasaApiClient;
    private static final ZoneId NASA_ZONE = ZoneId.of("America/New_York");

    public ApodService(ApodRepository apodRepository, NasaApiClient nasaApiClient) {
        this.apodRepository = apodRepository;
        this.nasaApiClient = nasaApiClient;
    }

    public ApodEntry getTodayApod(){
        LocalDate today = LocalDate.now(NASA_ZONE);
        return apodRepository.findByLocalDate(today)
                .orElseGet(() -> fetchAndSaveApod(today));
    }

    private ApodEntry fetchAndSaveApod(LocalDate date){
        //calls nasa and gets response of raw strings
        NasaApodResponse fetchApod = nasaApiClient.fetchTodayApod();

        //calls the String date and converts into LocalDate object as that's what
        //the entity takes in
        LocalDate apodDate = LocalDate.parse(fetchApod.getDate());

        //creates brand new entity
        ApodEntry entry = new ApodEntry(
                apodDate,
                fetchApod.getTitle(),
                fetchApod.getExplanation(),
                fetchApod.getUrl(),
                fetchApod.getMedia_type()
        );

        //saves into database; Hibernate treats it as new and adds an id to it
        return apodRepository.save(entry);
    }


}
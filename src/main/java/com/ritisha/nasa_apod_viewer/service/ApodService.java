package main.java.com.ritisha.nasa_apod_viewer.service;

import main.java.com.ritisha.nasa_apod_viewer.dto.NasaApodResponse;
import main.java.com.ritisha.nasa_apod_viewer.entity.ApodEntry;
import main.java.com.ritisha.nasa_apod_viewer.repository.ApodRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ApodService {
    private final ApodRepository apodRepository;
    private final NasaApiClient nasaApiClient;

    public ApodService(ApodRepository apodRepository, NasaApiClient nasaApiClient) {
        this.apodRepository = apodRepository;
        this.nasaApiClient = nasaApiClient;
    }

    public ApodEntry getTodayApod(){
        LocalDate today = LocalDate.now();
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
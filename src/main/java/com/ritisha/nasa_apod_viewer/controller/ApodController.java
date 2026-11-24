package main.java.com.ritisha.nasa_apod_viewer.controller;

import main.java.com.ritisha.nasa_apod_viewer.entity.ApodEntry;
import main.java.com.ritisha.nasa_apod_viewer.service.ApodService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/apods")

//added to bypass CORS policy; give frontend access to backend
@CrossOrigin(origins = "http://localhost:5500")
public class ApodController {

    private final ApodService apodService;

    public  ApodController(ApodService apodService) {
        this.apodService =  apodService;
    }

    @GetMapping
    public ApodEntry getApod() {
        return apodService.getTodayApod();
    }


}
package main.java.com.ritisha.nasa_apod_viewer.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class ApodEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate localDate;
    private String title;

    @Column(length = 4000)
    private String explanation;

    private String url;
    private String mediaType;

    protected ApodEntry() {}

    public ApodEntry(LocalDate localDate, String title, String explanation, String url, String mediaType) {
        this.localDate = localDate;
        this.title = title;
        this.explanation = explanation;
        this.url = url;
        this.mediaType = mediaType;
    }

    @Override
    public String toString() {
        return String.format(
                "ApodEntry[id=%d, localDate='%s', title='%s', explanation='%s',  url='%s', mediaType='%s']",
                id, localDate, title, explanation, url);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}
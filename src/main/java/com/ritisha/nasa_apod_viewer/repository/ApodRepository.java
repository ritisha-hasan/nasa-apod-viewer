package com.ritisha.nasa_apod_viewer.repository;

import com.ritisha.nasa_apod_viewer.entity.ApodEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ApodRepository extends JpaRepository<ApodEntry, Long> {
    Optional<ApodEntry> findByLocalDate(LocalDate localDate);
}
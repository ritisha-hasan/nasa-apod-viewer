# NASA APOD Viewer

A Java/Spring Boot REST API that fetches and serves NASA's Astronomy Picture of the Day.

**Status:** work in progress

## Tech
Java 21, Spring Boot, Spring Data JPA, H2 (PostgreSQL support planned)

## Setup
1. Get a free API key at https://api.nasa.gov
2. Copy `.env.example` to `.env` and add your key
3. Run `./mvnw spring-boot:run`
4. The app runs on http://localhost:8082

## Planned
- [ ] Endpoints for today's and past APODs
- [ ] PostgreSQL support
- [ ] Tests and error handling
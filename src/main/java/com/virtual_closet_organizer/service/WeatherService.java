package com.virtual_closet_organizer.service;

import com.virtual_closet_organizer.client.WeatherClient;
import com.virtual_closet_organizer.model.Weather;
import com.virtual_closet_organizer.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;


@Service
public class WeatherService {


    private final WebClient webClient;
    private final WeatherRepository weatherRepository;
    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${WEATHER_API_KEY}")
    private String apiKey;

    public WeatherService(WebClient.Builder webClient, WeatherRepository weatherRepository) {
        this.webClient = webClient.build();
        this.weatherRepository = weatherRepository;
    }
    public Weather getWeather(String lat , String lon) {

       String baseUrl = apiUrl;

        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .pathSegment(lat + "," + lon)

                .queryParam("unitGroup", "uk")
                .queryParam("include", "days,current,hours,alerts")
                .queryParam("key", apiKey)
                .queryParam("contentType", "json")
                .toUriString();
        weatherRepository.save(Objects.requireNonNull(webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Weather.class)
                .block()));

        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Weather.class)
                .block();

    }
}

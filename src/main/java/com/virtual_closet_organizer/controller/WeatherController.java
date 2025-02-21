package com.virtual_closet_organizer.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtual_closet_organizer.model.Weather;
import com.virtual_closet_organizer.service.SimpleEncryptDecryptService;
import com.virtual_closet_organizer.service.WeatherService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")

public class WeatherController {


    private final WeatherService weatherService;
    private final SimpleEncryptDecryptService simpleEncryptDecryptService;


    public WeatherController(WeatherService weatherService, SimpleEncryptDecryptService simpleEncryptDecryptService) {
        this.weatherService = weatherService;
        this.simpleEncryptDecryptService = simpleEncryptDecryptService;
    }


    @GetMapping("/get/{lat}/{lon}")
    public Weather getWeather(@PathVariable String lat ,@PathVariable String lon) throws Exception {
        String name = "prince changani";
        Weather weather = weatherService.getWeather(lat, lon);
        String  encryptedName =  simpleEncryptDecryptService.hashBase64String(name);

        // Convert the Weather object to JSON string using ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(weather);
        System.out.println("encryptedName : "+encryptedName);
        String response = simpleEncryptDecryptService.base64Encription(jsonResponse).replace("5",encryptedName);

        return weatherService.getWeather(lat, lon) ;
    }

}

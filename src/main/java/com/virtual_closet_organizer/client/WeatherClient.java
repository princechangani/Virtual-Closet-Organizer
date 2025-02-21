package com.virtual_closet_organizer.client;

import com.virtual_closet_organizer.model.Weather;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "weatherClient", url = "${weather.api.url}")
public interface WeatherClient {


    Weather getWeather(String city);
}

package com.oneot.weather_forecast.common.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Represents the weather conditions during the day period.
 * This class extends WeatherPeriod to specifically model daytime weather attributes.
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "day_forecast", indexes = {
    @Index(name = "idx_day_forecast_id", columnList = "id") // DAY is a reserved keyword. Changing the table name to avoid conflict
})
public class Day extends WeatherPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Constructs a new Day instance with the specified weather attributes.
     *
     * @param phenomenon The weather phenomenon during the day (e.g., "Sunny", "Cloudy", "Rainy").
     * @param tempMin The minimum temperature expected during the day.
     * @param tempMax The maximum temperature expected during the day.
     * @param places The places this day forecast is for.
     * @param text Additional textual description of the day weather.
     * @param peipsi Specific weather information for Peipsi during the day, if applicable.
     */
    public Day(String phenomenon, int tempMin, int tempMax, String text, List<Place> places, String peipsi) {
        super(phenomenon, tempMin, tempMax, text, places, peipsi); // Call the constructor of the WeatherPeriod superclass
    }

}

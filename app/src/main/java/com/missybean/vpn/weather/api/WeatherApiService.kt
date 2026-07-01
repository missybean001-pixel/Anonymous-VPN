package com.missybean.vpn.weather.api

import retrofit2.http.GET
import retrofit2.http.Query

data class WeatherResponse(
    val coord: Coord,
    val weather: List<Weather>,
    val main: Main,
    val wind: Wind,
    val clouds: Clouds,
    val sys: Sys,
    val name: String,
    val cod: Int
)

data class Coord(
    val lon: Double,
    val lat: Double
)

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val humidity: Int
)

data class Wind(
    val speed: Double,
    val deg: Int,
    val gust: Double? = null
)

data class Clouds(
    val all: Int
)

data class Sys(
    val country: String,
    val sunrise: Long,
    val sunset: Long
)

interface WeatherApiService {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherResponse

    @GET("weather")
    suspend fun getWeatherByCoordinates(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherResponse
}

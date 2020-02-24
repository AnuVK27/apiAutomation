package io.weather.automation

/*
This can be extended to be used to model the response object and be asserted
 */
data class Temperature(
    var temp: String,
    var feels_like: String,
    var temp_min: String,
    var temp_max: String,
    var pressure: String,
    var humidity: String
)
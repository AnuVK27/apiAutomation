package io.weather.automation


import org.testng.Assert
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test


class WeatherTests : BaseClass() {

    @BeforeTest
    @Override
    fun setUp() {

        BaseClass.setUp()
    }

    @Test(
        enabled = true,
        priority = 1,
        description = "Test Weather API for Different Cities",
        dataProvider = "Generate City Code & API Key",
        dataProviderClass = CityDataProvider::class
    )
    fun testWeatherForDifferentCities(city: String, apiKey: String, expectedStatusCode: Int) {

        val response = ApiUtils.getWeatherForCity(city, apiKey)
        //Assert on HTTP status Code
        Assert.assertTrue(response.statusCode == expectedStatusCode)
        if (response.statusCode == 200) {
            //Assert on City in the Response
            Assert.assertTrue(response.jsonPath().getString("name").contains(city))

        }
    }
}
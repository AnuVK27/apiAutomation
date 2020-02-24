package io.weather.automation

import org.testng.annotations.DataProvider

object CityDataProvider {

    @DataProvider(name = "Generate City Code & API Key")
    @JvmStatic
    fun generateData(): Array<Array<Any>> {

        val validAPIKey = UtilResources.getProperties("apiKey")
        val invalidAPIKey = "InvalidKey"
        val cityOfLondon = "London"
        val cityOfMünchen = "Munich"
        val expectedHTTPResponse = 200
        val unauthorized = 401


        return arrayOf(
            arrayOf(cityOfLondon, validAPIKey, expectedHTTPResponse),
            arrayOf(cityOfMünchen, validAPIKey, expectedHTTPResponse),
            arrayOf(cityOfMünchen, invalidAPIKey, unauthorized)
        )
    }

}
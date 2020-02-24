package io.weather.automation

import io.restassured.RestAssured
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification

open class ApiUtils : BaseClass(){

    companion object {

        fun getWeatherForCity(city: String, apiKey: String) : Response {


            return  RestAssured.given().contentType("application/json")
                .request().log().all()
                .whenever()
                .get("/data/2.5/weather?q=${city},&appid=${apiKey}")
                .then().log().all().extract().response()
        }

        fun RequestSpecification.whenever() : RequestSpecification {
            return this.`when`()
        }

    }
}
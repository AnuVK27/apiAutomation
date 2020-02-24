package io.weather.automation

import io.restassured.RestAssured
import io.restassured.config.HttpClientConfig

open class BaseClass {

    companion object {

        private fun setBaseURI(baseUri: String) {
            RestAssured.baseURI = baseUri
        }

        private fun connectionTimeout(timeOut: Int) {
            if (timeOut != null) {
                RestAssured.config = RestAssured.config().httpClient(
                    HttpClientConfig.httpClientConfig().setParam(
                        org.apache.http.client.params.ClientPNames.CONN_MANAGER_TIMEOUT,
                        java.lang.Long.valueOf(timeOut.toLong()))
                        .setParam(org.apache.http.params.CoreConnectionPNames.CONNECTION_TIMEOUT, timeOut)
                        .setParam(org.apache.http.params.CoreConnectionPNames.STALE_CONNECTION_CHECK, true))
            }
        }

        @JvmOverloads
        fun setUp() {
            setBaseURI(UtilResources.getProperties("baseUri"))
            RestAssured.useRelaxedHTTPSValidation()
            connectionTimeout(8000)
        }
    }


}
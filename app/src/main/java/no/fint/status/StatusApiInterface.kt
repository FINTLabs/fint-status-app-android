package no.fint.status

import no.fint.status.model.HealthCheckResponse
import retrofit2.Call
import retrofit2.http.GET

interface StatusApiInterface {

    @GET("/api/healthcheck")
    fun getApiStatus(): Call<List<HealthCheckResponse>>
}
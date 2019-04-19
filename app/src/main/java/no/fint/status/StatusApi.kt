package no.fint.status

import android.util.Log
import no.fint.status.model.HealthCheckResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StatusApi(private val baseUrl: String) {


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(OkHttpClient().newBuilder().build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun fetchApiStatus(): List<HealthCheckResponse> {
        val statusApiInterface = retrofit.create(StatusApiInterface::class.java)
        val apiStatus = statusApiInterface.getApiStatus()
        val execute = apiStatus.execute()
        if (execute.body() != null) {
            return execute.body()!!
        }
        Log.e("StatusApi", "Response unknown: ${execute.body()}")

        return emptyList()
    }
}
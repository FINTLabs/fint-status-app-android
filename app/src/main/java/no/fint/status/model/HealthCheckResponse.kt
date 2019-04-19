package no.fint.status.model

import com.google.gson.annotations.SerializedName

data class HealthCheckResponse(@SerializedName("apiBaseUrl")
                               val apiBaseUrl: String = "",
                               @SerializedName("event")
                               val event: Event)
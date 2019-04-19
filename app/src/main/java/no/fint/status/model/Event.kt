package no.fint.status.model

import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("data")
    val data: List<Any>?,
    @SerializedName("corrId")
    val corrId: String? = null,
    @SerializedName("source")
    val source: String? = "",
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("orgId")
    val orgId: String? = null,
    @SerializedName("action")
    val action: String? = null,
    @SerializedName("client")
    val client: String? = null,
    @SerializedName("time")
    val time: Long = 0,
    @SerializedName("status")
    val status: String? = null
)

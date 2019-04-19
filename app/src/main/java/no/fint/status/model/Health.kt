package no.fint.status.model

import com.google.gson.annotations.SerializedName

data class Health(@SerializedName("component")
                  val component: String = "",
                  @SerializedName("time")
                  val time: String = "",
                  @SerializedName("status")
                  val status: String = "",
                  @SerializedName("timestamp")
                  val timestamp: Long = 0)
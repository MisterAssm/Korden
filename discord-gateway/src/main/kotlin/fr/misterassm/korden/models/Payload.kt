package fr.misterassm.korden.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Payload(
    @SerialName(value = "op") val opCode: Int,
    @SerialName(value = "d") val eventData: JsonElement?,
    @SerialName(value = "s") val sequenceNumber: Int? = null,
    @SerialName(value = "t") val eventName: String? = null,
)

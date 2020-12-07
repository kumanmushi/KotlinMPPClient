package com.example.kotlinmppclient.shared.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dogs(
    @SerialName("message")
    val images: List<String>
)
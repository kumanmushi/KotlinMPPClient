package com.example.kotlinmppclient.shared.network

import com.example.kotlinmppclient.shared.entity.*
import io.ktor.client.HttpClient
import io.ktor.client.call.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class DogApi {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    private val baseUrl = "https://dog.ceo/api/breed/hound/images"

    suspend fun fetchDogs(count: Int): Dogs {
        return httpClient.get{ url("$baseUrl/random/${count.toString()}") }
    }
}

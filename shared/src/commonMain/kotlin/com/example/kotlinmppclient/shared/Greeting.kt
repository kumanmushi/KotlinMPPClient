package com.example.kotlinmppclient.shared

import com.example.kotlinmppclient.shared.network.DogApi
import com.example.kotlinmppclient.shared.entity.*

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}

class DogsKMMSDK() {
    private val api = DogApi()

    @Throws(Exception::class) suspend fun fetch(): Dogs {
        return api.fetchDogs(5)
    }
}
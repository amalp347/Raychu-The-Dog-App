package com.android.example.raychu.data.api

import com.android.example.raychu.data.model.response.breed
import retrofit2.http.GET
import retrofit2.http.Header

interface DogService {

    @GET("breeds")
    suspend fun getbreed(@Header("x-api-key") xApiKey: String): List<breed>

}
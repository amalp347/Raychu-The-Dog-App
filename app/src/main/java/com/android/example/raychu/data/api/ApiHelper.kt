package com.android.example.raychu.data.api

class ApiHelper(private val dogService: DogService) {
    suspend fun getbreed() = dogService.getbreed("baac4cac-a563-4d5b-9960-9d2ce1b771cf")
}
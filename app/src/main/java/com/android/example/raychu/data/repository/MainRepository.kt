package com.android.example.raychu.data.repository

import com.android.example.raychu.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getbreed() = apiHelper.getbreed()
}
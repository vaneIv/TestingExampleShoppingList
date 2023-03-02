package com.example.testingexampleshoppinglist.data.remote

import com.example.testingexampleshoppinglist.BuildConfig
import com.example.testingexampleshoppinglist.data.remote.responses.UnsplashResponse
import retrofit2.Response
import retrofit2.http.Query

interface UnsplashApi {

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
        const val CLIENT_ID = BuildConfig.UNSPLASH_ACCESS_API_KEY
    }

    suspend fun searchForImage(
        @Query("query") query: String
    ): Response<UnsplashResponse>
}
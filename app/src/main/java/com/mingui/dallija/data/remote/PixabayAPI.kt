package com.mingui.dallija.data.remote

import com.mingui.dallija.BuildConfig
import com.mingui.dallija.data.remote.responses.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayAPI {
    @GET("/api/")
    suspend fun searchForImage(
        @Query("q") searchQuery : String,
        @Query("key") apikey : String = BuildConfig.API_KEY
    ) : Response<ImageResponse>
}
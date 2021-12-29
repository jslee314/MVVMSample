package com.jslee.mvvmsample

import com.jslee.mvvmsample.data.dao.AdResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface AdService{
    @GET()
    suspend fun callAd(): AdResult
    }

const val BASE_URL = "https://thesimplycoder.herokuapp.com/marvel-heroes"

val apiRetrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

object AdApi {
    val adService: AdService by lazy {
        apiRetrofit.create(AdService::class.java)
    }
}

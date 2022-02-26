package com.example.geekssampleapp.api

import com.example.geekssampleapp.constants.APIConstants
import com.example.geekssampleapp.model.FeedResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET(APITags.feed + "rss_url=http://www.abc.net.au/news/feed/51120/rss.xml")
    fun getFeed(): Call<FeedResponse>

    companion object {
        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(APIConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}
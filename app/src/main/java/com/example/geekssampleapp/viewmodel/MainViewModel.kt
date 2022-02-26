package com.example.geekssampleapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geekssampleapp.model.FeedResponse
import com.example.geekssampleapp.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {
    val feedResponse = MutableLiveData<FeedResponse>()
    val errorMessage = MutableLiveData<String>()
    fun getAllFeed() {
        val response = repository.getFeed()
        response?.enqueue(object : Callback<FeedResponse> {
            override fun onResponse(call: Call<FeedResponse>, response: Response<FeedResponse>) {
                feedResponse.postValue(response.body())
            }
            override fun onFailure(call: Call<FeedResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}
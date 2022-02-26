package com.example.geekssampleapp.repository

import com.example.geekssampleapp.api.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getFeed() = retrofitService.getFeed()
}
package com.example.geekssampleapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.geekssampleapp.adapter.NewsFeedRvAdapter
import com.example.geekssampleapp.api.RetrofitService
import com.example.geekssampleapp.databinding.ActivityMainBinding
import com.example.geekssampleapp.model.FeedResponse
import com.example.geekssampleapp.repository.MainRepository
import com.example.geekssampleapp.viewmodel.MainViewModel
import com.example.geekssampleapp.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )
        binding.loading = true
        viewModel.feedResponse.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            binding.loading = false

            binding.data = it
            Glide.with(this).load(it.feed!!.image).placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder).into(binding.headerImage)
            setFeedRv(it.items)
        })
        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            binding.loading = false

        })
        viewModel.getAllFeed()

    }

    private fun setFeedRv(items: List<FeedResponse.Item>?) {

        if (!items.isNullOrEmpty()) {
            binding.rvFeed.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvFeed.adapter = NewsFeedRvAdapter(this, items)
        }

    }
}




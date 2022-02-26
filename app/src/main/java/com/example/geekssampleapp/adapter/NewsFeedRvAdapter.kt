package com.example.geekssampleapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.geekssampleapp.R
import com.example.geekssampleapp.databinding.FeedRvItemBinding
import com.example.geekssampleapp.model.FeedResponse

class NewsFeedRvAdapter(val context: Context, val feedList:List<FeedResponse.Item>):RecyclerView.Adapter<NewsFeedRvAdapter.ViewHolder>() {

    class ViewHolder(feedRvItemBinding: FeedRvItemBinding) : RecyclerView.ViewHolder(feedRvItemBinding.root) {
        var itemBinding=feedRvItemBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding=DataBindingUtil.inflate<FeedRvItemBinding>(LayoutInflater.from(context), R.layout.feed_rv_item,parent,false)
        return ViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.itemBinding.data=feedList[position]
        Glide.with(context).load(feedList[position].thumbnail).error(R.drawable.placeholder).placeholder(R.drawable.placeholder).into(holder.itemBinding.img)
        holder.itemBinding.executePendingBindings()
    }

    override fun getItemCount()=feedList.size
}
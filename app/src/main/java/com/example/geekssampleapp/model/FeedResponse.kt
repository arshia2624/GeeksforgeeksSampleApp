package com.example.geekssampleapp.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.geekssampleapp.model.FeedResponse.Feed
import com.example.geekssampleapp.model.FeedResponse.Enclosure

class FeedResponse {
    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("feed")
    @Expose
    var feed: Feed? = null

    @SerializedName("items")
    @Expose
    var items: List<Item>? = null

    class Feed {
        @SerializedName("url")
        @Expose
        var url: String? = null

        @SerializedName("title")
        @Expose
        var title: String? = null

        @SerializedName("link")
        @Expose
        var link: String? = null

        @SerializedName("author")
        @Expose
        var author: String? = null

        @SerializedName("description")
        @Expose
        var description: String? = null

        @SerializedName("image")
        @Expose
        var image: String? = null
    }

    class Item {
        @SerializedName("title")
        @Expose
        var title: String? = null

        @SerializedName("pubDate")
        @Expose
        var pubDate: String? = null

        @SerializedName("link")
        @Expose
        var link: String? = null

        @SerializedName("guid")
        @Expose
        var guid: String? = null

        @SerializedName("author")
        @Expose
        var author: String? = null

        @SerializedName("thumbnail")
        @Expose
        var thumbnail: String? = null

        @SerializedName("description")
        @Expose
        var description: String? = null

        @SerializedName("content")
        @Expose
        var content: String? = null

        @SerializedName("enclosure")
        @Expose
        var enclosure: Enclosure? = null

        @SerializedName("categories")
        @Expose
        var categories: List<String>? = null
    }

    class Enclosure {
        @SerializedName("link")
        @Expose
        var link: String? = null

        @SerializedName("type")
        @Expose
        var type: String? = null

        @SerializedName("thumbnail")
        @Expose
        var thumbnail: String? = null
    }
}
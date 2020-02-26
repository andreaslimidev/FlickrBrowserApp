package com.example.flickrbrowser1

// dataclass wil automatically implement toString()

data class Photo(
    val title: String,
    val author: String,
    val authorID: String,
    val link: String,
    val tags: String,
    val image: String)



package com.example.thedailynews

data class MainNews (
    var status: String,
    var totalresult: String,
    var articles: List<ModelClass>
        )
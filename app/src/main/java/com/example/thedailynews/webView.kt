package com.example.thedailynews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*

class webView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        setSupportActionBar(toolbar)

        val url = intent.getStringExtra("url")
        webView.webViewClient = WebViewClient()
        url?.let { webView.loadUrl(it) }
    }
}
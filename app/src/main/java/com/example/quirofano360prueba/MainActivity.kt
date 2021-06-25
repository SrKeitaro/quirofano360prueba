package com.example.quirofano360prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import io.ktor.server.engine.*
import io.ktor.server.netty.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        embeddedServer(Netty, 8080, "127.0.0.1"){
            module()
        }.start(wait = false)

        val webView = WebView(this)
        webView.loadUrl("http://localhost:8080")
        setContentView(webView)
    }
}
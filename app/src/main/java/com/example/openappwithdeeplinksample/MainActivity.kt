package com.example.openappwithdeeplinksample

import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.util.Log


class MainActivity : AppCompatActivity() {


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        getParameterLink()
    }

    fun getParameterLink() {
        // ATTENTION: This was auto-generated to handle app links.
        val appLinkIntent = intent
        val appLinkAction = appLinkIntent.action
        val appLinkData = appLinkIntent.data

        try {
            if(appLinkData?.getQueryParameter("test") != null) {
                Log.i("layon.f", appLinkData.getQueryParameter("test").toString())
                messageTV.text = appLinkData.getQueryParameter("test").toString()
            }
        } catch (ex: Exception) {
            Log.i("layon.f", "erro")
            finish()
        }
    }

    // creating a variable for our text view
    private lateinit var messageTV: TextView
    private var uri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initializing our variable
        messageTV = findViewById(R.id.idTVMessage)
        getParameterLink()

    }
}
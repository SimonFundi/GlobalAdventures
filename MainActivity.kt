package com.symonfundi.globaladventures

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var mEdtgokart: TextView? = null
    var mEdthiking: TextView? = null
    var mEdtbowling: TextView? = null
    var mEdtziplining: TextView? = null
    var mEdttext1: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEdtgokart = findViewById(R.id.mEdtgokart)
        mEdthiking = findViewById(R.id.mEdthiking)
        mEdtbowling = findViewById(R.id.mEdtbowling)
        mEdtziplining = findViewById(R.id.mEdtziplinning)
        mEdttext1 = findViewById(R.id.mEdttext1)

        mEdtgokart!!.setOnClickListener {
            var intents = Intent(this, Karting::class.java)
            startActivity(intents)
        }

        mEdthiking!!.setOnClickListener {
            var intents = Intent(this, hiking::class.java)
            startActivity(intents)
        }

        mEdtbowling!!.setOnClickListener {
            var intents = Intent(this, bowling::class.java)
            startActivity(intents)
        }
        mEdtziplining!!.setOnClickListener {
            var intents = Intent(this, ziplinning::class.java)
            startActivity(intents)
        }
        mEdttext1!!.setOnClickListener {
            var goToWebsite = Intent(applicationContext,website::class.java)
            startActivity(goToWebsite)
        }
    }
}





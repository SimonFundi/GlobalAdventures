package com.symonfundi.globaladventures

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ziplinning : AppCompatActivity() {

    var Mbtkart: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ziplinning)
        Mbtkart = findViewById(R.id.Mbtkart)

        Mbtkart!!.setOnClickListener {
            var intents = Intent(this, Login::class.java)
            startActivity(intents)
        }
    }
}
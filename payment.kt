package com.symonfundi.globaladventures

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class payment : AppCompatActivity() {
    lateinit var mImgmpesa: ImageView
    lateinit var mImgairtel: ImageView
    lateinit var mImgequitel: ImageView
    lateinit var Mbtkart1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

    mImgmpesa = findViewById(R.id.mImgmpesa)
    mImgairtel = findViewById(R.id.mImgairtel)
    mImgequitel = findViewById(R.id.mImgequitel)
    Mbtkart1 = findViewById(R.id.Mbtkart1)

        mImgmpesa.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }

        }

        mImgairtel.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }

        }

        mImgequitel.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }

        }


        Mbtkart1.setOnClickListener {
            val intents = Intent(this, Exit::class.java)
            startActivity(intents)
    }

}

}
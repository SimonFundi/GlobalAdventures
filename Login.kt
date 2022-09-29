package com.symonfundi.globaladventures

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var mEdtemail: EditText
    lateinit var mEdtpassword: EditText
    lateinit var mBtlogin: Button
    lateinit var mEdtRegister: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        mEdtemail = findViewById(R.id.mEdtemail)
        mEdtpassword = findViewById(R.id.mEdtpassword)
        mBtlogin = findViewById(R.id.mBtlogin)
        mEdtRegister = findViewById(R.id.mEdtRegister)
        mBtlogin.setOnClickListener {
            val email = mEdtemail.text.toString()
            val password = mEdtpassword.text.toString()

            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, payment::class.java)
                    startActivity(intent)
                    finish()
                }
            }.addOnFailureListener { exception ->
                Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }

        mEdtRegister.setOnClickListener {
            val intents = Intent(this, com.symonfundi.globaladventures.Register::class.java)
            startActivity(intents)
        }
    }


}



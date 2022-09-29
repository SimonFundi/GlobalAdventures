package com.symonfundi.globaladventures

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var mEdtemail: EditText
    lateinit var mEdtusername: EditText
    lateinit var mEdtpassword: EditText
    lateinit var mEdtpassword1: EditText
    lateinit var mBtnregister: Button
    lateinit var mEdtlogin: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //find views by id
        auth = Firebase.auth
        mEdtemail = findViewById(R.id.mEdtemail)
        mEdtusername = findViewById(R.id.mEdtusername)
        mEdtpassword = findViewById(R.id.mEdtpassword)
        mEdtpassword1 = findViewById(R.id.mEdtpassword1)
        mBtnregister = findViewById(R.id.mBtnregister)
        mEdtlogin = findViewById(R.id.mEdtlogin)

        mBtnregister.setOnClickListener {

//receive data from edittext

            val email = mEdtemail.text.toString().trim()
            val userName = mEdtusername.text.toString().trim()
            val password = mEdtpassword.text.toString().trim()
            val confirmPassword = mEdtpassword1.text.toString().trim()
            val currentTime = System.currentTimeMillis()

            if (userName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                (Toast.makeText(this, "Please fill this field", Toast.LENGTH_LONG)::show)
            }
            if (password != confirmPassword) {
                Toast.makeText(
                    this,
                    "Password and Confirm Password do not match",
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                // proceed to Save the data received to the cloud
                val id = System.currentTimeMillis().toString()
                val userData = User(userName, email, password, id)
// create  table in our cloud called Users
                val ref = FirebaseDatabase.getInstance().getReference().child("Users/$currentTime")

                //finally push th data to the cloud
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        ref.setValue(userData)
                        Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Log.d("saving_error", ""+it.exception!!.message)
                        Toast.makeText(this, ""+it.exception!!.message, Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }


        mEdtlogin.setOnClickListener {
            val intents = Intent(this, Login::class.java)
            startActivity(intents)
        }
    }
}



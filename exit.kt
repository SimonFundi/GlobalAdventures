package com.symonfundi.globaladventures

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.symonfundi.globaladventures.databinding.ActivityExitBinding
import kotlin.system.exitProcess


class Exit : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityExitBinding
    private lateinit var mBtnexit1:Button
    private lateinit var toolbar:androidx.appcompat.widget.Toolbar
    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_exit)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        mBtnexit1 = findViewById(R.id.mBtnexit1)
        mAuth = FirebaseAuth.getInstance()

        mBtnexit1.setOnClickListener{
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
            startActivity(shareIntent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {true}
            R.id.action_karting -> {
                val intents = Intent(this, Karting::class.java)
                startActivity(intents)
                true
            }

            R.id.action_bowling -> {
                val intents = Intent(this, bowling::class.java)
                startActivity(intents)
                true
            }
            R.id.action_hiking -> {
                val intents = Intent(this, hiking::class.java)
                startActivity(intents)
                true
            }
            R.id.action_ziplining -> {
                val intents = Intent(this, ziplinning::class.java)
                startActivity(intents)
                true
            }
            R.id.action_logout -> {
                mAuth.signOut()
                val i = Intent(this@Exit, Login::class.java)
                startActivity(i)
                finish()
                true
            }
            R.id.action_exit -> {
                val activity = Exit()
                activity.finish()
                exitProcess(0)
            }


            else -> super.onOptionsItemSelected(item)
        }
    }


}
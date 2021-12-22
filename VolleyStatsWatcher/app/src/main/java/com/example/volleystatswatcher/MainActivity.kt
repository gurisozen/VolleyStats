package com.example.volleystatswatcher

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.volleystatswatcher.databinding.ActivityMainBinding
import android.widget.Button
import android.widget.Toast
import android.widget.EditText
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val watchmatch=findViewById<Button>(R.id.watchmatch)
        watchmatch.setOnClickListener { view ->

            addRecord()
        }
        watchmatch.setOnClickListener {
            val intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }

    //Method for saving the employee records in database
    private fun addRecord() {
        val obj=findViewById<EditText>(R.id.asd2)
        val matchid = obj.text.toString()
        val obj2=findViewById<EditText>(R.id.asd)
        val total_score = obj.text.toString().toInt()
        val databaseHandler: DataBaseHandler = DataBaseHandler(this)
        if (!matchid.isEmpty() && total_score!=0) {
            val status =
                databaseHandler.addMatch(MatchClass(0, matchid,total_score))
            if (status > -1) {
                Toast.makeText(applicationContext, "Record saved", Toast.LENGTH_LONG).show()
                obj.text.clear()
                obj2.text.clear()
            }
        } else {
            Toast.makeText(
                applicationContext,
                "Invalid entry: Match Id empty or start score is 0!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
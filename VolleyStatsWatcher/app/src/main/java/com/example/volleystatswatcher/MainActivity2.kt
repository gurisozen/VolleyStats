package com.example.volleystatswatcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val updateScore=findViewById<Button>(R.id.updatescore)
        val datab = DataBaseHandler(this, null)
        datab.getScore()
        updateScore.setOnClickListener{

            val db = DataBaseHandler(this, null)

            // below is the variable for cursor
            // we have called method to get
            // all names from our database
            // and add to name text view
            val cursor = db.getScore()

            // moving the cursor to first position and
            // appending value in the text view
            val id=findViewById<TextView>(R.id.id)
            val score=findViewById<TextView>(R.id.score)

            id.append(cursor.getString(cursor.getColumnIndex(DataBaseHandler.KEY_MATCH_ID)) + "\n")
            score.append(cursor.getString(cursor.getColumnIndex(DataBaseHandler.KEY_SCORE)) + "\n")

            // moving our cursor to next
            // position and appending values
            while(cursor.moveToNext()){
                id.append(cursor.getString(cursor.getColumnIndex(DataBaseHandler.KEY_MATCH_ID)) + "\n")
                score.append(cursor.getString(cursor.getColumnIndex(DataBaseHandler.KEY_SCORE)) + "\n")
            }

            // at last we close our cursor
            cursor.close()
        }
    }

    }

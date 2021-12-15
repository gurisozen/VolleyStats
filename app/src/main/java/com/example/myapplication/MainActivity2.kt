package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val cevbutton=findViewById<Button>(R.id.button_id_cev)
        cevbutton.setOnClickListener {
            val intent=Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
        val sultanbutton=findViewById<Button>(R.id.button_id_sultanlar)
        sultanbutton.setOnClickListener {
            val intent=Intent(this,MainActivity9::class.java)
            startActivity(intent)
        }
        val fivbutton=findViewById<Button>(R.id.button_id_fivb)
        fivbutton.setOnClickListener {
            val intent=Intent(this,MainActivity10::class.java)
            startActivity(intent)
        }
        supportActionBar!!.title=("Go Back")
        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)
    }

}
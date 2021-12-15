package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val cevbutton=findViewById<Button>(R.id.button_id_match1)
        cevbutton.setOnClickListener {
            val intent= Intent(this,MainActivity4::class.java)
            startActivity(intent)

        }
        val cevbutton2=findViewById<Button>(R.id.button_id_match2)
        cevbutton2.setOnClickListener {
            val intent= Intent(this,MainActivity5::class.java)
            startActivity(intent)
        }
        val cevbutton3=findViewById<Button>(R.id.button_id_match3)
        cevbutton3.setOnClickListener {
            val intent= Intent(this,MainActivity6::class.java)
            startActivity(intent) }
        val cevbutton4=findViewById<Button>(R.id.button_id_match4)
        cevbutton4.setOnClickListener {
            val intent= Intent(this,MainActivity7::class.java)
            startActivity(intent) }
        val cevbutton5=findViewById<Button>(R.id.button_id_match5)
        cevbutton5.setOnClickListener {
            val intent= Intent(this,MainActivity8::class.java)
            startActivity(intent) }
        supportActionBar!!.title=("Go Back")
        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)

    }
}
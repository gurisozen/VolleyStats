package com.example.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main4.*


class MainActivity10 : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences
    var scoreFromDatabase : Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)
        supportActionBar!!.title=("Go Back")
        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)
        sharedPreferences = this.getSharedPreferences("com.example.myapplication", MODE_PRIVATE)
        scoreFromDatabase = sharedPreferences.getInt("match6",0)

        if (scoreFromDatabase == 0){
            textView.text = "Score: "
        }else{
            textView.text = " Block Score: $scoreFromDatabase"
        }
    }
    fun save(view : View){

        val score = editText2.text.toString().toIntOrNull()

        if(score != null) {
            textView.text = "Block Score: " + score
            sharedPreferences.edit().putInt("match6", score).apply()
        }
    }
    fun reset(view : View){
        scoreFromDatabase = sharedPreferences.getInt("match6",0)
        if( scoreFromDatabase != 0){
            sharedPreferences.edit().remove("match6").apply()
            textView.text = "Block Score: "
        }
    }
}
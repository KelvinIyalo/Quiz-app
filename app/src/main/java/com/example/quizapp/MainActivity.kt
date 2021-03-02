package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        val KEY = "Gamer_Name"
        val SCORE = "SCORE"
        val TOTAL_QUESTION = "QUESTION"

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        btn_start.setOnClickListener {
            userValidation()
        }

    }

    private fun userValidation(){
        val Name = tv_Game_name_editText.text.toString()
        if (Name.isEmpty()){
            tv_Game_name_layout.error = "Name can not be Empty"
        }
        else{
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(KEY, Name)
            startActivity(intent)
            finish()
        }
    }
}

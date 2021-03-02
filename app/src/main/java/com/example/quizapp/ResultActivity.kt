package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    private var mUserName:String?=null
    private var mScore:Int? =null
    private var mTotal_Question:Int? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        mUserName = intent.getStringExtra(MainActivity.KEY)
        mScore = intent.getIntExtra(MainActivity.SCORE,0)
        mTotal_Question = intent.getIntExtra(MainActivity.TOTAL_QUESTION,1)

        username.text = mUserName
        score.text = "your score is ${mScore} out of ${mTotal_Question}"
        result_btn.setOnClickListener{
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}

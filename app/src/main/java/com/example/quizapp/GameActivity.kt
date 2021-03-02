package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.MainActivity.Companion.KEY
import com.example.quizapp.MainActivity.Companion.SCORE
import com.example.quizapp.MainActivity.Companion.TOTAL_QUESTION
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition:Int = 1
    private var mQuestionsList:ArrayList<Questions>? = null
    private var mSelectedOptionPosition:Int = 0
    private var mCorrectAnswer:Int = 0
    private var mUserName:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        mUserName = intent.getStringExtra(KEY)
      Toast.makeText(this,mUserName,Toast.LENGTH_LONG).show()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mQuestionsList = Constants.getQuestions()
        setQuestion()
        option_one.setOnClickListener(this)
        option_two.setOnClickListener(this)
        option_three.setOnClickListener(this)
        option_four.setOnClickListener(this)
        submit_btn.setOnClickListener(this)

    }

    private fun setQuestion(){

defaultOptionView()
        if (mCurrentPosition == mQuestionsList!!.size){

            submit_btn.text = "FINISH"
        }else{
            submit_btn.text = "SUBMIT"
        }
        val questions= mQuestionsList!![mCurrentPosition -1]
        progress_bar.progress = mCurrentPosition
        count_progress.text = "$mCurrentPosition" + "/" + progress_bar.max
        question_tag.text = questions?.question
        quest_image.setImageResource(questions!!.image)
        option_one.text = questions.OptionOne
        option_two.text = questions.OptionTwo
        option_three.text = questions.OptionThree
        option_four.text = questions.OptionFour



    }

    private fun defaultOptionView(){

        val options = ArrayList<TextView>()
        options.add(0,option_one)
        options.add(1,option_two)
        options.add(2,option_three)
        options.add(3,option_four)
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.initial_question_bg)

        }

    }

    override fun onClick(v: View?) {
    when(v?.id){

    R.id.option_one ->{selectedOptionView(option_one,1)
    }
    R.id.option_two ->{selectedOptionView(option_two,2)}
    R.id.option_three -> {selectedOptionView(option_three,3)}
    R.id.option_four -> {selectedOptionView(option_four,4)}
        R.id.submit_btn ->{
            if (mSelectedOptionPosition == 0){
                mCurrentPosition++
                when{
                    mCurrentPosition <= mQuestionsList!!.size ->{setQuestion()}else ->
                {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(KEY, mUserName)
                    intent.putExtra(SCORE, mCorrectAnswer)
                    intent.putExtra(TOTAL_QUESTION, mQuestionsList!!.size)
                    startActivity(intent)
                    finish()
                }
                }
            }
            else{
                val question = mQuestionsList?.get(mCurrentPosition -1)
                if (question!!.CorrectAnswer != mSelectedOptionPosition){
                    answerView(mSelectedOptionPosition,R.drawable.wrong_question_bg)
                }else{mCorrectAnswer++}
                answerView(question.CorrectAnswer,R.drawable.correct_question_bg)
                if (mCurrentPosition == mQuestionsList!!.size){

                    submit_btn.text = "FINISH"
                }else{
                    submit_btn.text = "GO TO NEXT QUESTION"
                }
                mSelectedOptionPosition = 0
            }
        }

        }

    }

    private fun selectedOptionView(tv:TextView,selectedOption:Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOption
       // tv.setTextColor(Color.parseColor("#5E35B1"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_question_bg)
    }

    private fun answerView(answer:Int,drawableView:Int){

        when(answer){
            1 ->{option_one.background = ContextCompat.getDrawable(this,drawableView)}
            2 ->{option_two.background = ContextCompat.getDrawable(this,drawableView)}
            3 ->{option_three.background = ContextCompat.getDrawable(this,drawableView)}
            4 ->{option_four.background = ContextCompat.getDrawable(this,drawableView)}
        }
    }
}

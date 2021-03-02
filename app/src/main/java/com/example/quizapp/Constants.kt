package com.example.quizapp

import java.util.*
import kotlin.collections.ArrayList

object Constants {
    fun getQuestions(): ArrayList<Questions> {

        val questionsList = ArrayList<Questions>()

        val que1 = Questions(1,"Which Country does this Flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Angola","Nigeria",
            "Argentina","England",3)
        questionsList.add(que1)

        //Quesion 2
        val que2 = Questions(2,"Which Country does this Flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Australia","China",
            "Mali","Korea",1)
        questionsList.add(que2)

        //Quesion 3
        val que3 = Questions(3,"Which Country does this Flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Ghana","Japan",
            "Turkey","Belgium",4)
        questionsList.add(que3)

        //Quesion 4
        val que4 = Questions(4,"Which Country does this Flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Liberia","Brazil",
            "UAE","South Africa",2)
        questionsList.add(que4)

        //Quesion 5
        val que5 = Questions(5,"Which Country does this Flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Belgium","Japan",
            "Denmark","England",3)
        questionsList.add(que5)

        //Quesion 6
        val que6 = Questions(6,"Which Country does this Flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Togo","Australia",
            "Argentina","Fiji",4)
        questionsList.add(que6)

        //Quesion 7
        val que7 = Questions(7,"Which Country does this Flag belong to?",
            R.drawable.ic_flag_of_india,
            "India","Libya",
            "Jamaica","Belgium",1)
        questionsList.add(que7)

        //Quesion 8
        val que8 = Questions(8,"Which Country does this Flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Mali","Kuwait",
            "Senegal","South Africa",2)
        questionsList.add(que8)

        //Quesion 9
        val que9 = Questions(9,"Which Country does this Flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Mexico","New Zealand",
            "Panama","Nicaragua",2)
        questionsList.add(que9)

        //Quesion 9
        val que10 = Questions(10,"Which Country does this Flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Mexico","Germany",
            "Panama","Nicaragua",2)
        questionsList.add(que10)
        questionsList.shuffle()
        return questionsList
    }

}
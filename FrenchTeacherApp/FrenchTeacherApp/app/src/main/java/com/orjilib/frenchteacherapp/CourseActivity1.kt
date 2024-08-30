package com.orjilib.frenchteacherapp

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CourseActivity1 : AppCompatActivity(), View.OnClickListener {
    private var thirdpgtitle: TextView? = null
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_course1)

        //initializing text view and all the buttons
        thirdpgtitle = findViewById(R.id.textView2)
        one = findViewById(R.id.onebtn)
        two = findViewById(R.id.twobtn)
       three = findViewById(R.id.threebtn)
        four = findViewById(R.id.fourbtn)
        five = findViewById(R.id.fivebtn)

        val i = intent

        //handling all the buttons on click listeners
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View) {
        //Getting Button Id for all buttons
        val clickedBtnId = view.id

        //Checking to see which button id was clicked
        if (clickedBtnId == R.id.onebtn) {
            playSounds(R.raw.one)
        } else if (clickedBtnId == R.id.twobtn) {
            playSounds(R.raw.two)
        } else if (clickedBtnId == R.id.threebtn) {
            playSounds(R.raw.three)
        } else if (clickedBtnId == R.id.fourbtn) {
            playSounds(R.raw.four)
        } else if (clickedBtnId == R.id.fivebtn) {
            playSounds(R.raw.five)
        }
    }

    //Creating a method for playing all the sounds
    fun playSounds(id: Int) {
        val player1 = MediaPlayer.create(this, id)

        player1.start()
    }
}

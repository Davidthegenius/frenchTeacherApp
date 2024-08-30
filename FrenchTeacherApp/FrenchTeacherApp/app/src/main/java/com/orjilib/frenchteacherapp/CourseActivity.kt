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

class CourseActivity : AppCompatActivity(), View.OnClickListener {
    private var thirdpgtitle: TextView? = null
    private lateinit var red: Button
    private lateinit var black: Button
    private lateinit var purple: Button
    private lateinit var green: Button
    private lateinit var yellow: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_course)

        //initializing text view and all the buttons
        thirdpgtitle = findViewById(R.id.textView2)
        red = findViewById(R.id.redbtn)
        black = findViewById(R.id.blackbtn)
        purple = findViewById(R.id.purplebtn)
        green = findViewById(R.id.greenbtn)
        yellow = findViewById(R.id.yellowbtn)

        val i = intent

        //handling all the buttons on click listeners
        red.setOnClickListener(this)
        black.setOnClickListener(this)
        purple.setOnClickListener(this)
        green.setOnClickListener(this)
        yellow.setOnClickListener(this)

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
        if (clickedBtnId == R.id.redbtn) {
            playSounds(R.raw.red)
        } else if (clickedBtnId == R.id.blackbtn) {
            playSounds(R.raw.black)
        } else if (clickedBtnId == R.id.purplebtn) {
            playSounds(R.raw.purple)
        } else if (clickedBtnId == R.id.greenbtn) {
            playSounds(R.raw.green)
        } else if (clickedBtnId == R.id.yellowbtn) {
            playSounds(R.raw.yellow)
        }
    }

    //Creating a method for playing all the sounds
    fun playSounds(id: Int) {
        val player1 = MediaPlayer.create(this, id)

        player1.start()
    }
}

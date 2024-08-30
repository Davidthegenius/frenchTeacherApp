package com.orjilib.frenchteacherapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CoursePage2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_course_page2)

        val remark = findViewById<TextView>(R.id.cp2txtHead)
        val opentxt1 = findViewById<TextView>(R.id.cp2txtHead2)
        val helloBird = findViewById<ImageView>(R.id.imageViewCpg2)
        val colourBtn = findViewById<Button>(R.id.namepgbtncpg2)
        val numberBtn = findViewById<Button>(R.id.number)
        val quizBtn =findViewById<Button>(R.id.quiz)

        val i = intent
        val fName = i.getStringExtra("name")

        remark.text = "Hi $fName!"

        colourBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@CoursePage2,
                    CourseActivity::class.java
                )
            )
        }
        numberBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@CoursePage2,
                    CourseActivity1::class.java
                )
            )
        }
        quizBtn.setOnClickListener {
            Toast.makeText(this, "Feature coming soon!!",Toast.LENGTH_LONG).show()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
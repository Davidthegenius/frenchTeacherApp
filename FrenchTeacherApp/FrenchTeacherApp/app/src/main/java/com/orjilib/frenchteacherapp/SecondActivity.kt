package com.orjilib.frenchteacherapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var secpgbtn: Button
    private lateinit var secpgtxt: TextView
    private lateinit var secpgtxt2: TextView
    private lateinit var inptxt: EditText
    private lateinit var img2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        secpgbtn = findViewById(R.id.namepgbtn)
        secpgtxt = findViewById(R.id.textView3)
        secpgtxt2 = findViewById(R.id.textView4)
        inptxt = findViewById(R.id.editText)
        img2 = findViewById(R.id.imageViewpg2)

        secpgbtn.setOnClickListener(View.OnClickListener {
            val username = inptxt.getText().toString()
            //declaring my intent
            val j = Intent(this@SecondActivity, CoursePage2::class.java)
            // sending data between the application
            j.putExtra("name", username)
            startActivity(j)
        })


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
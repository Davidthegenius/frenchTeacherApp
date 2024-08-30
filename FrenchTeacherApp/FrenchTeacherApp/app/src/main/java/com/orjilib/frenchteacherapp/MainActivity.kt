package com.orjilib.frenchteacherapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var apphead: TextView
    private lateinit var appimg1: ImageView
    private lateinit var homepgbtn: Button
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        apphead = findViewById(R.id.textView)
        appimg1 = findViewById(R.id.imageView)
        homepgbtn = findViewById(R.id.movebtn)
        progressBar = findViewById(R.id.progressBar)

        homepgbtn.setOnClickListener(View.OnClickListener {
            progressBar.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                progressBar.visibility = View.GONE
                Toast.makeText(this, "Welcome",Toast.LENGTH_SHORT).show()
            },600)
            startActivity(
                Intent(
                    this@MainActivity, SecondActivity::class.java
                )
            )
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

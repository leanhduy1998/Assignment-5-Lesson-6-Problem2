package com.example.assignment_5_lesson_6_problem2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val title = intent.getStringExtra("title")
        val price = intent.getStringExtra("price")
        val color = intent.getStringExtra("color")
        val imageId = intent.getStringExtra("imageId")
        val itemid = intent.getStringExtra("itemid")
        val desc = intent.getStringExtra("desc")

        findViewById<ImageView>(R.id.imageView2).setImageResource(imageId!!.toInt())
        findViewById<TextView>(R.id.titleDetail).text = title
        findViewById<TextView>(R.id.colorDetail).text = color
        findViewById<TextView>(R.id.idDetail).text = itemid
        findViewById<TextView>(R.id.descriptionDetail).text = desc
    }
}
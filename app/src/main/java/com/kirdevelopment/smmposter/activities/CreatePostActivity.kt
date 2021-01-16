package com.kirdevelopment.smmposter.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.kirdevelopment.smmposter.R

class CreatePostActivity : AppCompatActivity() {
    private lateinit var cancelBtn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        cancelBtn = findViewById(R.id.createPostCancel)

        cancelBtn.setOnClickListener {
            finish()
        }

    }
}
package com.kirdevelopment.smmposter.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kirdevelopment.smmposter.R

class CreatePostActivity : AppCompatActivity() {
    private lateinit var cancelBtn: ImageView
    private lateinit var behavior: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        cancelBtn = findViewById(R.id.createPostCancel)
        behavior = findViewById(R.id.behavior)

        cancelBtn.setOnClickListener {
            finish()
        }

        initMiscellaneous()

    }


    private fun initMiscellaneous() {
        val layoutMiscellaneous: LinearLayout = findViewById(R.id.layoutMiscellaneous)
        val bottomSheetBehavior: BottomSheetBehavior<LinearLayout> = BottomSheetBehavior.from(layoutMiscellaneous)

        behavior.setOnClickListener {
            if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }

    }
}
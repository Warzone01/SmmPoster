package com.kirdevelopment.smmposter.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kirdevelopment.smmposter.R
import com.kirdevelopment.smmposter.presenters.CreatePresenter
import com.kirdevelopment.smmposter.room.database.PostsDatabase
import com.kirdevelopment.smmposter.room.entities.Post
import com.kirdevelopment.smmposter.views.CreateView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.text.SimpleDateFormat
import java.util.*

class CreatePostActivity : MvpAppCompatActivity(), CreateView {
    private lateinit var cancelBtn: ImageView
    private lateinit var saveBtn: ImageView
    private lateinit var behavior: View
    private lateinit var postBody: EditText
    private lateinit var createDate: TextView
    private lateinit var postDate: TextView
    private lateinit var pDB: PostsDatabase

    @InjectPresenter
    lateinit var createPostPresenter: CreatePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        cancelBtn = findViewById(R.id.createPostCancel)
        behavior = findViewById(R.id.behavior)
        postBody = findViewById(R.id.createPostTextBody)
        createDate = findViewById(R.id.createPostDate)
        saveBtn = findViewById(R.id.createPostSaveBtn)

        pDB = PostsDatabase.getDatabase(applicationContext)

        createDate.text = SimpleDateFormat(
                "EEEE, dd MMMM yyyy HH:mm a",
                Locale.getDefault())
                .format(Date())

        saveBtn.setOnClickListener {
            save()
        }

        cancelBtn.setOnClickListener {
            cancel()
        }
        initMiscellaneous()


    }

    override fun save() {

        if(postBody.toString().trim().isEmpty()){
            Toast.makeText(this, "Пост не может быть пустым", Toast.LENGTH_SHORT).show()
            return
        }

        createPostPresenter.save(this,
                postBody.text.toString(),
                createDate.text.toString(),
                "",
                "",
                "",
                "")

        val intent = Intent()
        setResult(Activity.RESULT_OK, intent)
        finish()

    }

    override fun cancel() {
        finish()
    }

    override fun initMiscellaneous() {
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


    override fun delete() {

    }

    override fun selectImage(path: String) {

    }

    override fun selectVideo(path: String) {

    }

    override fun selectAudio(path: String) {

    }

    override fun selectDate(path: String) {

    }
}
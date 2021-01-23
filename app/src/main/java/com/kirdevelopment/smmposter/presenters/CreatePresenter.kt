package com.kirdevelopment.smmposter.presenters

import android.content.Context
import android.widget.Toast
import com.kirdevelopment.smmposter.room.database.PostsDatabase
import com.kirdevelopment.smmposter.room.entities.Post
import com.kirdevelopment.smmposter.views.CreateView
import moxy.InjectViewState
import moxy.MvpPresenter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


@InjectViewState
class CreatePresenter: MvpPresenter<CreateView>() {



    fun save(context: Context,
             desc:String,
             createDate: String,
             postDate: String,
             imgPath: String,
             audioPath: String,
             videoPath: String){
        var pDB: PostsDatabase = PostsDatabase.getDatabase(context)
        val post = Post()

        post.description = desc
        post.createDate = createDate
        post.postDate = postDate
        post.imgPath = imgPath
        post.audioPath = audioPath
        post.videoPath = videoPath

        doAsync {
            pDB.dao().insert(post)
            uiThread {
                Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
            }
        }

    }

}
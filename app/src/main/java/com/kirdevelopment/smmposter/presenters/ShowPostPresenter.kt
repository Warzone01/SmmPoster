package com.kirdevelopment.smmposter.presenters

import android.content.Context
import com.kirdevelopment.smmposter.adapters.PostListAdapter
import com.kirdevelopment.smmposter.room.database.PostsDatabase
import com.kirdevelopment.smmposter.room.entities.Post
import com.kirdevelopment.smmposter.views.ShowPostView
import moxy.InjectViewState
import moxy.MvpPresenter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

@InjectViewState
class ShowPostPresenter: MvpPresenter<ShowPostView>() {

    val REQUEST_CODE_ADD_NOTE: Int = 1
    val REQUEST_CODE_SHOW_NOTE: Int = 3

    fun getPosts(request:Int, context:Context, postAdapter: PostListAdapter, isPostDeleted: Boolean, postList: ArrayList<Post>){
        doAsync {
            val list = PostsDatabase.getDatabase(context).dao().getAllPosts()
            uiThread {
                if(request == REQUEST_CODE_SHOW_NOTE) {
                    postList.addAll(list)
                    postAdapter.notifyDataSetChanged()
                } else if(request == REQUEST_CODE_ADD_NOTE){
                    postList.add(0, list[0])
                    postAdapter.notifyItemInserted(0)
                }
            }
        }

    }


}
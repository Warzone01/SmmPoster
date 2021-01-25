package com.kirdevelopment.smmposter.activities

import android.content.Intent
import android.content.SyncRequest
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kirdevelopment.smmposter.R
import com.kirdevelopment.smmposter.adapters.PostListAdapter
import com.kirdevelopment.smmposter.presenters.ShowPostPresenter
import com.kirdevelopment.smmposter.room.entities.Post
import com.kirdevelopment.smmposter.views.ShowPostView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class ShowPostActivity : MvpAppCompatActivity(), ShowPostView {

    val REQUEST_CODE_SHOW_NOTE: Int = 3

    private lateinit var posterRV: RecyclerView
    private lateinit var searchEditText: EditText
    private lateinit var menuIcon: ImageView
    private lateinit var btnCreatePost: ImageView
    private lateinit var emptyListText: TextView
    private lateinit var postAdapter: PostListAdapter
    private var postList: ArrayList<Post> = ArrayList()

    @InjectPresenter
    lateinit var showPostPresenter: ShowPostPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_post)

        posterRV = findViewById(R.id.postRV)
        searchEditText = findViewById(R.id.postSearchField)
        menuIcon = findViewById(R.id.menuButton)
        btnCreatePost = findViewById(R.id.showPostButtonCreateNew)
        emptyListText = findViewById(R.id.showPostTextEmpty)

        posterRV.layoutManager = LinearLayoutManager(this@ShowPostActivity)
        postAdapter = PostListAdapter(postList)
        posterRV.adapter = postAdapter

        showAllNotes(REQUEST_CODE_SHOW_NOTE)

        btnCreatePost.setOnClickListener{
            addNewPost()
        }
    }

    override fun startLoading() {

    }

    override fun endLoading() {

    }

    override fun showError(string: String) {

    }

    override fun showAllNotes(request: Int) {

        showPostPresenter.getPosts(request, this,postAdapter, false, postList)
        
    }

    override fun showEmptyList() {
        emptyListText.visibility = View.VISIBLE
    }

    override fun clickListener() {

    }

    override fun addNewPost() {
        startActivity(Intent(this@ShowPostActivity, CreatePostActivity::class.java))
    }
}
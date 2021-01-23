package com.kirdevelopment.smmposter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.createBitmap
import androidx.recyclerview.widget.RecyclerView
import com.kirdevelopment.smmposter.R
import com.kirdevelopment.smmposter.room.entities.Post
import com.squareup.picasso.Picasso
import java.util.*

class PostListAdapter(private var postsList: List<Post>): RecyclerView.Adapter<PostListAdapter.ViewHolder>()  {
    private val mPostsList: List<Post> = postsList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postsList[position])
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val media: ImageView = itemView.findViewById(R.id.itemImagePreview)
        private val desc: TextView = itemView.findViewById(R.id.postItemDescription)
        private val createDate: TextView = itemView.findViewById(R.id.postItemCreateDate)
        private val postDate: TextView = itemView.findViewById(R.id.postItemPostedDate)

        fun bind(post: Post){
            if(post.imgPath != ""){
                Picasso.get()
                        .load(post.imgPath)
                        .into(media)
            } else {
                media.visibility = View.GONE
            }

            if(post.description.trim().isNotEmpty()){
                desc.text = post.description
            } else {
                desc.text = "empty"
            }
            createDate.text = post.createDate

            if (post.postDate.trim().isNotEmpty()){
                postDate.text = post.postDate
            } else {
                postDate.visibility = View.GONE
            }

        }
    }

}
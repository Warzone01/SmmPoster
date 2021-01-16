package com.kirdevelopment.smmposter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kirdevelopment.smmposter.R
import java.util.*

class PostListAdapter: RecyclerView.Adapter<PostListAdapter.ViewHolder>()  {
    private val mPostList: MutableList<Any> = LinkedList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return mPostList.count()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val media: ImageView = itemView.findViewById(R.id.itemImagePreview)
        private val desc: TextView = itemView.findViewById(R.id.postItemDescription)
        private val createDate: TextView = itemView.findViewById(R.id.postItemCreateDate)
        private val postDate: TextView = itemView.findViewById(R.id.postItemPostedDate)

        fun bind(){

        }
    }

}
package com.kirdevelopment.smmposter.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kirdevelopment.smmposter.room.entities.Post

@Dao
interface Dao {
    @Insert
    fun insertAll(posts: Post)

    @Delete
    fun delete(post: Post)

    @Query("SELECT * FROM posts ORDER BY id DESC")
    fun getAllPosts():List<Post>
}
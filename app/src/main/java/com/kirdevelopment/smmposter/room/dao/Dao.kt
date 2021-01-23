package com.kirdevelopment.smmposter.room.dao

import androidx.room.*
import androidx.room.Dao
import com.kirdevelopment.smmposter.room.entities.Post

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: Post)

    @Delete
    fun delete(post: Post)

    @Query("SELECT * FROM posts ORDER BY id DESC")
    fun getAllPosts():List<Post>
}
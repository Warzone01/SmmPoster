package com.kirdevelopment.smmposter.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kirdevelopment.smmposter.room.dao.Dao
import com.kirdevelopment.smmposter.room.entities.Post


@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class PostsDatabase:RoomDatabase() {

    abstract fun dao():Dao
    companion object {
        private var postsDatabase:PostsDatabase? = null
        fun getDatabase(context:Context) : PostsDatabase{
            if (postsDatabase == null){
                postsDatabase = Room.databaseBuilder(
                        context,
                        PostsDatabase::class.java,
                        "postsDb"
                ).build()
            }
            return postsDatabase as PostsDatabase
        }
    }

}
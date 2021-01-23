package com.kirdevelopment.smmposter.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "posts")
class Post(@PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name = "description") var description:String,
    @ColumnInfo(name = "create_date") var createDate: String,
    @ColumnInfo(name = "post_date") var postDate: String,
    @ColumnInfo(name = "img_path") var imgPath: String,
    @ColumnInfo(name = "vid_path") var videoPath: String,
    @ColumnInfo(name = "audio_path") var audioPath: String
){
    constructor():this(null,
    "",
    "",
    "",
    "",
    "",
    "")
}

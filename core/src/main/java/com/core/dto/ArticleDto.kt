package com.core.dto

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity(tableName = "article")
data class ArticleDto(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "local_id", index = true)
    @Keep val localId: Long = 0,
    @Keep
    var author: String,
    @Keep
    var title: String,
    @Keep
    var description: String,
    @Keep
    var url: String,
    @Keep
    var urlToImage: String,
    @Keep
    var publishedAt: String,
    @Keep
    var content: String,
    @Keep
    var source: SourceDto
) : Parcelable

@Keep
@Parcelize
data class SourceDto(
    @Keep
    var id: String,
    @Keep
    var name: String
) : Parcelable
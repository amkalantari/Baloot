package com.core.dto

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Keep
@Parcelize
@Entity(tableName = "config")
data class ConfigEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "local_id", index = true) @Keep val localId: Long = 0,
    @Keep var callCenter: String,
    @Keep var planBUrl: String,
) : Parcelable

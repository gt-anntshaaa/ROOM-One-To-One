package com.application.multipletable.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Users(
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "email") val email: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    var userId: Int = 0
}

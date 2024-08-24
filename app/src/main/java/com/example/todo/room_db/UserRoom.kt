package com.example.todo.room_db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "users")
data class UserRoom(

    @PrimaryKey
    @ColumnInfo(name = "user_id")  // Explicitly setting column name (optional in this case)
    val userId: Int,

    @ColumnInfo(name = "user_name")  // Changing column name
    val name: String,

    @ColumnInfo(name = "user_email")  // Changing column name
    val email: String,

    @ColumnInfo(name = "user_phone")  // Changing column name
    val phone: String,

    @ColumnInfo(name = "profile_image_url")  // Changing column name
    val profileImage: String,

    @ColumnInfo(name = "created_at")  // Explicitly setting column name (optional in this case)
    val createdAt: String,

    @ColumnInfo(name = "is_login")
    val isLogIn: Boolean
)

package com.example.todo.room_db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    @SerializedName("user_id")
    @ColumnInfo(name = "user_id")  // Explicitly setting column name (optional in this case)
    val userId: Int,

    @SerializedName("name")
    @ColumnInfo(name = "user_name")  // Changing column name
    val name: String,

    @SerializedName("email")
    @ColumnInfo(name = "user_email")  // Changing column name
    val email: String,

    @SerializedName("phone")
    @ColumnInfo(name = "user_phone")  // Changing column name
    val phone: String,

    @SerializedName("profile_image")
    @ColumnInfo(name = "profile_image_url")  // Changing column name
    val profileImage: String,

    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")  // Explicitly setting column name (optional in this case)
    val createdAt: String
)


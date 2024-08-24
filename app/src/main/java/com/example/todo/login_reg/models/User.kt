package com.example.todo.login_reg.models


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("user_id")
    val userId: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("profile_image")
    val profileImage: String,

    @SerializedName("created_at")
    val createdAt: String
)


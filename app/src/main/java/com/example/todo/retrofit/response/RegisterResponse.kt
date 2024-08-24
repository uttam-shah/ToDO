package com.example.todo.retrofit.response



import com.example.todo.login_reg.models.User
import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("message")
    val message: String,

    @SerializedName("user")
    val user: User
)

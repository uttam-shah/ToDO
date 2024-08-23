package com.example.todo.retrofit


import com.example.todo.retrofit.response.LoginResponse
import com.example.todo.retrofit.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiSet {
    @FormUrlEncoded
    @POST("register.php") // Adjust the endpoint path as needed
    fun registerUser(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("password") password: String,
        @Field("profile_image") profileImage: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("login.php")
    fun loginUser(
        @Field("input") input: String,
        @Field("password") password: String
    ): Call<LoginResponse>
}
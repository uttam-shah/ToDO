package com.example.todo.retrofit


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitController private constructor() {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    companion object {
        private const val BASE_URL = "http://192.168.1.12/to_do/"
        @Volatile
        private var clientInstance: RetrofitController? = null

        fun getInstance(): RetrofitController {
            return clientInstance ?: synchronized(this) {
                clientInstance ?: RetrofitController().also { clientInstance = it }
            }
        }
    }

    fun getApiService(): ApiSet {
        return retrofit.create(ApiSet::class.java)
    }
}

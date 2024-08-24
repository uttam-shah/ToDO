package com.example.todo.room_db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): List<UserRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userRoom: UserRoom)

    @Query("SELECT * FROM users LIMIT 1")
    suspend fun getUser(): UserRoom?

    @Insert
    fun insertAll(vararg users: UserRoom)

    @Delete
    fun delete(user: UserRoom)
}
package com.example.todo.room_db

import android.content.Context
import androidx.room.Room

class BgThread(
    private val context: Context
) : Thread() {

    // Define operations that can be performed
    enum class OperationType {
        INSERT, DELETE, RETRIEVE
    }

    private lateinit var operationType: OperationType
    private var user: User? = null

    // Function to perform insert operation
    fun performInsert(user: User) {
        this.operationType = OperationType.INSERT
        this.user = user
        start()
    }

    // Function to perform delete operation
    fun performDelete(user: User) {
        this.operationType = OperationType.DELETE
        this.user = user
        start()
    }

    // Function to perform retrieve operation
    fun performRetrieve() {
        this.operationType = OperationType.RETRIEVE
        start()
    }

    override fun run() {
        super.run()

        // Initialize the database
        val db = Room.databaseBuilder(context, AppDatabase::class.java, "Room-db").build()
        val userDao = db.userDao()

        when (operationType) {
            OperationType.INSERT -> {
                user?.let {
                    userDao.insertAll(it)
                }
            }
            OperationType.DELETE -> {
                user?.let {
                    userDao.delete(it)
                }
            }
            OperationType.RETRIEVE -> {
                val users = userDao.getAll()
                // Do something with the retrieved data (like sending it to a handler)
            }
        }
    }
}

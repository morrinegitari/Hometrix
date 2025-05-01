package com.morrine.hometrix.repository

import com.morrine.hometrix.data.UserDao
import com.morrine.hometrix.model.User

class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.loginUser(email, password)
    }
}

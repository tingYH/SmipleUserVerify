package com.example.chengkaidemo.ui.auth

import androidx.lifecycle.ViewModel
import com.example.chengkaidemo.data.db.entities.User
import com.example.chengkaidemo.data.repositories.UserRepository

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel() {

    fun getLoggedInUser() = repository.getUser()

    suspend fun userLogin(
        email: String, password: String
    ) = repository.userLogin(email, password)

    suspend fun saveLoggedInUser(user: User) = repository.saveUser(user)
}
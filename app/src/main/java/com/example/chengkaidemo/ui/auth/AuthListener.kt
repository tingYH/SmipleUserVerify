package com.example.chengkaidemo.ui.auth

import androidx.lifecycle.LiveData
import com.example.chengkaidemo.data.db.entities.User

interface AuthListener {
    fun onStarted()

    fun onSuccess(user :User)

    fun onFailure(message: String)
}
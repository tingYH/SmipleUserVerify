package com.example.chengkaidemo.data.repositories

import com.example.chengkaidemo.data.db.AppDatabase
import com.example.chengkaidemo.data.db.AppDatabase_Impl
import com.example.chengkaidemo.data.db.entities.User
import com.example.chengkaidemo.data.network.MyApi
import com.example.chengkaidemo.data.network.SafeApiRequest
import com.example.chengkaidemo.data.network.response.AuthResponse
import retrofit2.Response
import retrofit2.http.Field

class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {
    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
//        return MyApi().userLogin(email, password)
    }

    suspend fun userSignup(name: String, email: String, password: String): AuthResponse {
        return apiRequest { api.userSignup(name, email, password) }
    }

    suspend fun saveUser(usr: User) = db.getUserDao().upsert(usr)

    fun getUser() = db.getUserDao().getuser()

}
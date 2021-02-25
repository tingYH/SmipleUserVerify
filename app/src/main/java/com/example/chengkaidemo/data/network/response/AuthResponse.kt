package com.example.chengkaidemo.data.network.response

import com.example.chengkaidemo.data.db.entities.User

/**
 *
 * @author ChengKai YH
 * @version $
 * <p/>
 * <p/> $
 */
data class AuthResponse(
    var isSuccessful: Boolean? = null,
    var message: String? = null,
    var user: User? = null
)
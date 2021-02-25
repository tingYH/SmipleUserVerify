package com.example.chengkaidemo.data.network

import com.example.chengkaidemo.utils.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

/**
 *
 * @author ChengKai YH
 * @version $
 * <p/>
 * <p/> $
 */

abstract class SafeApiRequest {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val message = StringBuilder()
            val error = response.errorBody()?.string()
            error?.let {
                try {
                    message.append(JSONObject(it).get("message"))
                } catch (e: JSONException) {
                    message.append("\n")
                }
            }
            message.append("Error Code: ${response.code()}")
            throw ApiException(message.toString())
        }
    }
}
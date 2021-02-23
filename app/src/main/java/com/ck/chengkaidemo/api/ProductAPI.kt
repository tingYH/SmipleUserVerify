package com.ck.chengkaidemo.api

import okhttp3.*
import org.json.JSONArray
import java.io.IOException

/**
 *
 * @author ChengKai YH
 * @version $
 * <p/>
 * <p/> $
 */
class ProductAPI : IProductAPI {

    override fun getProduct(productId: String, loadAPICallBack: IProductAPI.LoadAPICallBack) {
        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/posts/1")
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
            }

            override fun onResponse(call: Call?, response: Response?) {
                val resStr = response?.body()
                val productResponse = ProductResponse()
                val array = JSONArray(resStr)
                for (i in 0..array.length()) {
                    val jsonObject = array.getJSONObject(i)
                    productResponse.title = jsonObject.getString("title");
                    loadAPICallBack.onGetResult(productResponse)
                }
            }
        })
    }
}
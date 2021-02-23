package com.ck.chengkaidemo.api

/**
 *
 * @author ChengKai YH
 * @version $
 * <p/>
 * <p/> $
 */
interface IProductAPI {
    interface LoadAPICallBack {
        fun onGetResult(productResponse: ProductResponse)
    }
    fun getProduct(productId:String, loadAPICallBack: LoadAPICallBack)
}



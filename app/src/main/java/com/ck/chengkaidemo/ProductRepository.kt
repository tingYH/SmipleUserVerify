package com.ck.chengkaidemo

import android.util.Log
import com.ck.chengkaidemo.api.IProductAPI
import com.ck.chengkaidemo.api.ProductResponse

/**
 *
 * @author ChengKai YH
 * @version $
 * <p/>
 * <p/> $
 */
class ProductRepository(private val productAPI: IProductAPI) : IProductRepository {

    override fun getProduct(productId: String, loadProductCallback: IProductRepository.LoadProductCallback) {
        Log.i("getProduct"," call getProduct")
        productAPI.getProduct(productId, object: IProductAPI.LoadAPICallBack {
            override fun onGetResult(productResponse: ProductResponse) {
                loadProductCallback.onProductResult(productResponse)
            }
        })
    }

    override fun buy(id: String, items: Int, callback: IProductRepository.BuyProductCallback) {
        Log.i("buy"," call Buy")
        callback.onBuyResult(true)
    }
}
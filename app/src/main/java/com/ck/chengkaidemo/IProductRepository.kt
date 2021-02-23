package com.ck.chengkaidemo

import com.ck.chengkaidemo.api.ProductResponse

/**
 *
 * @author ChengKai YH
 * @version $
 * <p/>
 * <p/> $
 */
interface IProductRepository {
    fun getProduct (productId: String, loadProductCallback: LoadProductCallback)

    fun buy(id: String, items: Int, callback: BuyProductCallback)

    interface LoadProductCallback {
        fun onProductResult(productResponse: ProductResponse)
    }

    interface BuyProductCallback {
        fun onBuyResult(isSuccess: Boolean)
    }
}
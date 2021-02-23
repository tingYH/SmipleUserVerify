package com.ck.chengkaidemo

import android.util.Log
import androidx.databinding.ObservableField
import com.ck.chengkaidemo.api.ProductResponse

/**
 *
 * @author ChengKai YH
 * @version $
 * <p/>
 * <p/> $
 */
class ProductViewModel(private val productRepository: IProductRepository) {
    var title: ObservableField<String> = ObservableField("")

    fun getProduct(productId: String) {
        productRepository.getProduct(productId,
            object : IProductRepository.LoadProductCallback {
                override fun onProductResult(productResponse: ProductResponse) {
                    title.set(productResponse.title)

                }
            })
    }

    fun buy(){

        print("Click")
    }
}


package com.ck.chengkaidemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ck.chengkaidemo.api.ProductAPI
import com.ck.chengkaidemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val productId = "pixel3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataBinding = DataBindingUtil
            .setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val productAPI = ProductAPI()
        val productRepository = ProductRepository(productAPI)

        val productViewModel = ProductViewModel(productRepository)

        dataBinding.productViewModel = productViewModel

        //加這一段就可以讓model有變就更新回UI
        dataBinding.lifecycleOwner = this

        productViewModel.getProduct(productId)
    }
}
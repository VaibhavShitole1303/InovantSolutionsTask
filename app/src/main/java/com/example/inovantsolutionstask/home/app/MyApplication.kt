package com.example.inovantsolutionstask.home.app

import android.app.Application
import com.example.inovantsolutionstask.home.api.ProductsAPI
import com.example.inovantsolutionstask.home.repository.ProductRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MyApplication :Application() {
     lateinit var productsAPI: ProductsAPI
     lateinit var productRepository: ProductRepository

    override fun onCreate() {
        super.onCreate()
        val retrofit=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://klinq.com/")
            .build()

        productsAPI=retrofit.create(ProductsAPI::class.java)
        productRepository=ProductRepository(productsAPI)
    }
}
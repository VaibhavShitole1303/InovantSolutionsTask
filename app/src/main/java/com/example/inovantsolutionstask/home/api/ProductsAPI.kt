package com.example.inovantsolutionstask.home.api

import com.example.inovantsolutionstask.home.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface ProductsAPI {
    @GET("rest/V1/productdetails/6701/253620?lang=en&store=KWD")
    suspend fun getProducts():Response<Products>
}
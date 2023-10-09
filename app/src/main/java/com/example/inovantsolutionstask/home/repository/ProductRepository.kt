package com.example.inovantsolutionstask.home.repository

import androidx.lifecycle.MutableLiveData
import com.example.inovantsolutionstask.home.api.ProductsAPI
import com.example.inovantsolutionstask.home.model.Products
import com.example.inovantsolutionstask.home.network.NetworkResult

class ProductRepository(private  val productsAPI: ProductsAPI) {

    private val productLiveData=MutableLiveData<Products>()


//    val products:LiveData<Products>
//        get() = productLiveData
//    suspend fun getProducts(){
//        val result=productsAPI.getProducts()
//        if (result.body()!=null){
//            productLiveData.postValue(result.body())
//        }
//    }

    suspend fun getProduct(): NetworkResult<Products> {
        val response=productsAPI.getProducts()
        return  if (response.isSuccessful){
            val responseBody=response.body()
            if (responseBody!= null){
                NetworkResult.Success(responseBody)
            }else{
                NetworkResult.Error("Something went wrong")
            }
        }else{
            NetworkResult.Error("Something went wrong")
        }
    }
}
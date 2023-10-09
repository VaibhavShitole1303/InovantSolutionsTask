package com.example.inovantsolutionstask.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.inovantsolutionstask.home.repository.ProductRepository

class ProductViewModelFactory(private  val productRepository: ProductRepository):
                     ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(productRepository) as T
    }
}
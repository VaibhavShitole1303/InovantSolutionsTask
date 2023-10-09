package com.example.inovantsolutionstask.home.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.inovantsolutionstask.R
import com.example.inovantsolutionstask.databinding.ActivityMainBinding
import com.example.inovantsolutionstask.home.app.MyApplication
import com.example.inovantsolutionstask.home.model.Attributes
import com.example.inovantsolutionstask.home.model.ConfigurableOption
import com.example.inovantsolutionstask.home.model.Products
import com.example.inovantsolutionstask.home.model.Banner
import com.example.inovantsolutionstask.home.model.Data
import com.example.inovantsolutionstask.home.ui.adapters.BannerAdapter
import com.example.inovantsolutionstask.home.ui.adapters.ColorAdapter
import com.example.inovantsolutionstask.home.utils.CustomProgressDialog
import com.example.inovantsolutionstask.home.network.NetworkResult
import com.example.inovantsolutionstask.home.viewmodel.ProductViewModel
import com.example.inovantsolutionstask.home.viewmodel.ProductViewModelFactory

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivityMainBinding
    private val bannerList: ArrayList<Banner> = arrayListOf()
    private val colorList: ArrayList<String> = arrayListOf()
    private var bannerAdapter: BannerAdapter? = null
    private lateinit var productViewModel: ProductViewModel
    private  var products: Products?=null
    private lateinit var data: Data
    private lateinit var configurableOption:ArrayList<ConfigurableOption>
    private lateinit var attributes:ArrayList<Attributes>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val repository=(application as MyApplication).productRepository
        productViewModel=ViewModelProvider(this,ProductViewModelFactory(repository)).get(ProductViewModel::class.java)
        productViewModel.getProducts()
        Log.e("test",products.toString())
        initObserver()
        initListener()


    }

    private fun initListener() {
        binding.onClickListener=this
    }


    private fun initObserver() {
        CustomProgressDialog.showProgressDialog(this)
        productViewModel.product.observe(this) {
            when (it) {
                is NetworkResult.Loading->{
                        CustomProgressDialog.showProgressDialog(this)

                }
                is NetworkResult.Success -> {
                    CustomProgressDialog.dismissProgressDialog()
//                    binding.layoutProgress.isVisible=false
                    Log.d("vaibhav", it.toString())
//                    Toast.makeText(this, "ok", Toast.LENGTH_LONG).show()
                    binding.tvDiscription.setText(it.toString())
                    data = it.data?.data!!
                    Log.e("testData", data.toString())
                    configurableOption = data.configurableOption
                    Log.e("testconfigurableOption", configurableOption.toString())

                    attributes = configurableOption[0].attributes
//                    configurableOption.forEach{
//                        attributes.add( it.attributes)
//                    }
                    Log.e("testattributes", attributes.toString())
                    getData()


                }

                is NetworkResult.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                }

                else -> {
                    Toast.makeText(this, "data Error", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun getData() {
        binding.tvBrandName.text=data.brandName
         binding.tvPrice.text=data.price
        binding.tvDiscription.setText(Html.fromHtml(data.description))
//        binding.tvDiscription.text=data.description.toString()
        binding.tvOneCollection.text=data.name
        binding.tvSku.text= getString(R.string.sku, data.sku)
        bannerList.add(Banner(data.images))
        initAdapter()

    }

    private fun initAdapter() {

        bannerAdapter = BannerAdapter(data.images)
        binding.viewPager.adapter = bannerAdapter
        binding.springDotsIndicator.setViewPager2(binding.viewPager)

//         if (attributes.isEmpty()){
//             attributes.forEach{ colorList.add(it.images[0])}
//         }
        attributes.forEach{ colorList.add(it.images[0])}
        Log.e("colorList",colorList.toString())
        binding.colorAdapter = ColorAdapter(this, colorList)


    }

    override fun onClick(v: View?) {
        var count=1
        when(v?.id){
            R.id.iv_arrow , R.id.lbl_product_info->{
                if (!binding.tvDiscription.isVisible){
                    binding.tvDiscription.isVisible=true
                    binding.ivArrow.setImageResource(R.drawable.baseline_keyboard_arrow_up_24)
                }
                else{
                    binding.tvDiscription.isVisible=false
                    binding.ivArrow.setImageResource(R.drawable.baseline_keyboard_arrow_down_24)
                }
            }
            R.id.btn_pluse->{
//                   count.inc()
//                binding.tvCount.text  = count.toString()
            }
            R.id.btn_minus->{
//                count.dec()
//                binding.tvCount.text  =count.toString()
            }

            R.id.btn_add_to_bag->{
                Toast.makeText(this,"Added to bag successfully",Toast.LENGTH_LONG).show()
            }

            R.id.btn_share->{
                Toast.makeText(this,"sharing",Toast.LENGTH_LONG).show()
            }

        }
    }

}
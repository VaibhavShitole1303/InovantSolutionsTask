package com.example.inovantsolutionstask.home.model

import com.google.gson.annotations.SerializedName


data class Products (

  @SerializedName("status"  ) var status  : Int?    = null,
  @SerializedName("message" ) var message : String? = null,
  @SerializedName("data"    ) var data    : Data?   = Data()

)
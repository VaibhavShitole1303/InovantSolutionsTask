package com.example.inovantsolutionstask.home.model

import com.google.gson.annotations.SerializedName


data class ConfigurableOption (

  @SerializedName("attribute_id"   ) var attributeId   : Int?                  = null,
  @SerializedName("type"           ) var type          : String?               = null,
  @SerializedName("attribute_code" ) var attributeCode : String?               = null,
  @SerializedName("attributes"     ) var attributes    : ArrayList<Attributes> = arrayListOf()

)
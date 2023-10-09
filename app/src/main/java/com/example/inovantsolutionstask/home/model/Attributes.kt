package com.example.inovantsolutionstask.home.model

import com.google.gson.annotations.SerializedName


data class Attributes (

  @SerializedName("value"               ) var value             : String?           = null,
  @SerializedName("option_id"           ) var optionId          : String?           = null,
  @SerializedName("attribute_image_url" ) var attributeImageUrl : String?           = null,
  @SerializedName("price"               ) var price             : String?           = null,
  @SerializedName("images"              ) var images            : ArrayList<String> = arrayListOf(),
  @SerializedName("color_code"          ) var colorCode         : String?           = null,
  @SerializedName("swatch_url"          ) var swatchUrl         : String?           = null

)
package com.example.inovantsolutionstask.home.model

import com.google.gson.annotations.SerializedName


data class Data (

  @SerializedName("id"                  ) var id                 : String?                       = null,
  @SerializedName("sku"                 ) var sku                : String?                       = null,
  @SerializedName("name"                ) var name               : String?                       = null,
  @SerializedName("attribute_set_id"    ) var attributeSetId     : String?                       = null,
  @SerializedName("price"               ) var price              : String?                       = null,
  @SerializedName("final_price"         ) var finalPrice         : String?                       = null,
  @SerializedName("status"              ) var status             : String?                       = null,
  @SerializedName("type"                ) var type               : String?                       = null,
  @SerializedName("web_url"             ) var webUrl             : String?                       = null,
  @SerializedName("brand_name"          ) var brandName          : String?                       = null,
  @SerializedName("brand"               ) var brand              : String?                       = null,
  @SerializedName("brand_banner_url"    ) var brandBannerUrl     : String?                       = null,
  @SerializedName("is_salable"          ) var isSalable          : Boolean?                      = null,
  @SerializedName("is_new"              ) var isNew              : Int?                          = null,
  @SerializedName("is_sale"             ) var isSale             : Int?                          = null,
  @SerializedName("is_trending"         ) var isTrending         : Int?                          = null,
  @SerializedName("is_best_seller"      ) var isBestSeller       : Int?                          = null,
  @SerializedName("image"               ) var image              : String?                       = null,
  @SerializedName("created_at"          ) var createdAt          : String?                       = null,
  @SerializedName("updated_at"          ) var updatedAt          : String?                       = null,
  @SerializedName("weight"              ) var weight             : String?                       = null,
  @SerializedName("description"         ) var description        : String?                       = null,
  @SerializedName("short_description"   ) var shortDescription   : String?                       = null,
  @SerializedName("how_to_use"          ) var howToUse           : String?                       = null,
  @SerializedName("manufacturer"        ) var manufacturer       : String?                       = null,
  @SerializedName("meta_title"          ) var metaTitle          : String?                       = null,
  @SerializedName("meta_keyword"        ) var metaKeyword        : String?                       = null,
  @SerializedName("meta_description"    ) var metaDescription    : String?                       = null,
  @SerializedName("size_chart"          ) var sizeChart          : String?                       = null,
  @SerializedName("wishlist_item_id"    ) var wishlistItemId     : Int?                          = null,
  @SerializedName("has_options"         ) var hasOptions         : String?                       = null,
  @SerializedName("options"             ) var options            : ArrayList<String>             = arrayListOf(),
  @SerializedName("bundle_options"      ) var bundleOptions      : ArrayList<String>             = arrayListOf(),
  @SerializedName("configurable_option" ) var configurableOption : ArrayList<ConfigurableOption> = arrayListOf(),
  @SerializedName("remaining_qty"       ) var remainingQty       : Int?                          = null,
  @SerializedName("images"              ) var images             : ArrayList<String>             = arrayListOf(),
  @SerializedName("upsell"              ) var upsell             : ArrayList<String>             = arrayListOf(),
  @SerializedName("related"             ) var related            : ArrayList<String>             = arrayListOf()

)
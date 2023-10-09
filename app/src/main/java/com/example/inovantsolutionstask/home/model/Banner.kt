package com.example.inovantsolutionstask.home.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("banner")
    var banner: ArrayList<String>
)



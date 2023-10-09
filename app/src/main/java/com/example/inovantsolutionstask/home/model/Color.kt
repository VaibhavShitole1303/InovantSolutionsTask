package com.example.inovantsolutionstask.home.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Color() : Parcelable {



    @SerializedName("title")
    var image: String? = null

    constructor(parcel: Parcel) : this() {
        image = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Color> {
        override fun createFromParcel(parcel: Parcel): Color {
            return Color(parcel)
        }

        override fun newArray(size: Int): Array<Color?> {
            return arrayOfNulls(size)
        }
    }


}
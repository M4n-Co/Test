package com.example.test.productDetails.model

import android.os.Parcel
import android.os.Parcelable

data class ProductParcelable (
    val description: String,
    val images: List<String>,
    val price: Int,
    val title: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.createStringArrayList() ?: emptyList(),
        parcel.readInt(),
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(description)
        parcel.writeStringList(images)
        parcel.writeInt(price)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductParcelable> {
        override fun createFromParcel(parcel: Parcel): ProductParcelable {
            return ProductParcelable(parcel)
        }

        override fun newArray(size: Int): Array<ProductParcelable?> {
            return arrayOfNulls(size)
        }
    }
}
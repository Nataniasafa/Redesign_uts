package com.natania.redesign.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelVirus (
    var name: String,
    var price: String,
    var img: Int
): Parcelable
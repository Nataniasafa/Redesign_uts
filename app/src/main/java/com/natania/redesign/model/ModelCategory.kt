package com.natania.redesign.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelCategory (
    var name_category: String,
    var img_category: Int
): Parcelable
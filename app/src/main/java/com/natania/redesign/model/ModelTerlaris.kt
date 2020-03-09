package com.natania.redesign.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


    @Parcelize
    data class ModelTerlaris (
        var name_terlaris: String,
        var price_terlaris: String,
        var img_terlaris: Int
    ): Parcelable

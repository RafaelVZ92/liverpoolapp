package com.rafaelvelazquez.requestmanager.data.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Navigation(
    @SerializedName("ancester")
    val ancester: List<Ancester>?,
    @SerializedName("current")
    val current: List<Current>?
): Parcelable

@Parcelize
data class Ancester(
    @SerializedName("categoryId")
    val categoryId: String?,
    @SerializedName("label")
    val label: String?
) : Parcelable

@Parcelize
data class Current(
    @SerializedName("categoryId")
    val categoryId: String?,
    @SerializedName("label")
    val label: String?
): Parcelable
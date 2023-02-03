package com.rafaelvelazquez.requestmanager.data.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductsResponse(
    @SerializedName("status")
    val status: Status?,
    @SerializedName("pageType")
    val pageType: String?,
    @SerializedName("plpResults")
    val plpResults: PlpResults?,
): Parcelable

@Parcelize
data class Status(
    @SerializedName("status")
    val status: String?,
    @SerializedName("statusCode")
    val statusCode: Int
): Parcelable

@Parcelize
data class PlpResults(
    @SerializedName("label")
    val label: String?,
    @SerializedName("plpState")
    val plpState: PlpState?,
    @SerializedName("navigation")
    val navigation: Navigation?,
    @SerializedName("records")
    val records: List<Record>?,
    @SerializedName("refinementGroups")
    val refinementGroups: List<RefinementGroup>?,
    @SerializedName("sortOptions")
    val sortOptions: List<SortOption>?
): Parcelable

@Parcelize
data class PlpState(
    @SerializedName("categoryId")
    val categoryId: String?,
    @SerializedName("currentFilters")
    val currentFilters: String?,
    @SerializedName("currentSortOption")
    val currentSortOption: String?,
    @SerializedName("firstRecNum")
    val firstRecNum: Int?,
    @SerializedName("lastRecNum")
    val lastRecNum: Int?,
    @SerializedName("originalSearchTerm")
    val originalSearchTerm: String?,
    @SerializedName("plpSellerName")
    val plpSellerName: String?,
    @SerializedName("recsPerPage")
    val recsPerPage: Int?,
    @SerializedName("totalNumRecs")
    val totalNumRecs: Int?
): Parcelable

@Parcelize
data class SortOption(
    @SerializedName("label")
    val label: String?,
    @SerializedName("sortBy")
    val sortBy: String?
): Parcelable

@Parcelize
data class Refinement(
    @SerializedName("colorHex")
    val colorHex: String?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("high")
    val high: String?,
    @SerializedName("label")
    val label: String?,
    @SerializedName("low")
    val low: String?,
    @SerializedName("refinementId")
    val refinementId: String?,
    @SerializedName("searchName")
    val searchName: String?,
    @SerializedName("selected")
    val selected: Boolean?,
    @SerializedName("type")
    val type: String?
): Parcelable

@Parcelize
data class RefinementGroup(
    @SerializedName("dimensionName")
    val dimensionName: String?,
    @SerializedName("multiSelect")
    val multiSelect: Boolean?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("refinement")
    val refinement: List<Refinement>?
): Parcelable
package com.rafaelvelazquez.requestmanager.data.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Record(
    @SerializedName("brand")
    val brand: String?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("dwPromotionInfo")
    val dwPromotionInfo: DwPromotionInfo,
    @SerializedName("groupType")
    val groupType: String?,
    @SerializedName("isExpressFavoriteStore")
    val isExpressFavoriteStore: Boolean?,
    @SerializedName("isExpressNearByStore")
    val isExpressNearByStore: Boolean?,
    @SerializedName("isHybrid")
    val isHybrid: Boolean?,
    @SerializedName("isImportationProduct")
    val isImportationProduct: Boolean?,
    @SerializedName("isMarketPlace")
    val isMarketPlace: Boolean?,
    @SerializedName("lgImage")
    val lgImage: String?,
    @SerializedName("listPrice")
    val listPrice: Double?,
    @SerializedName("maximumListPrice")
    val maximumListPrice: Double?,
    @SerializedName("maximumPromoPrice")
    val maximumPromoPrice: Double?,
    @SerializedName("minimumListPrice")
    val minimumListPrice: Double?,
    @SerializedName("minimumPromoPrice")
    val minimumPromoPrice: Double?,
    @SerializedName("productAvgRating")
    val productAvgRating: Double?,
    @SerializedName("productDisplayName")
    val productDisplayName: String?,
    @SerializedName("productId")
    val productId: String?,
    @SerializedName("productRatingCount")
    val productRatingCount: Int?,
    @SerializedName("productType")
    val productType: String?,
    @SerializedName("promoPrice")
    val promoPrice: Double?,
    @SerializedName("promotionalGiftMessage")
    val promotionalGiftMessage: String?,
    @SerializedName("seller")
    val seller: String?,
    @SerializedName("skuRepositoryId")
    val skuRepositoryId: String?,
    @SerializedName("smImage")
    val smImage: String?,
    @SerializedName("variantsColor")
    val variantsColor: List<VariantsColor>?,
    @SerializedName("xlImage")
    val xlImage: String?
): Parcelable

@Parcelize
data class VariantsColor(
    @SerializedName("colorHex")
    val colorHex: String?,
    @SerializedName("colorImageURL")
    val colorImageURL: String?,
    @SerializedName("colorMainURL")
    val colorMainURL: String?,
    @SerializedName("colorName")
    val colorName: String?,
    @SerializedName("skuId")
    val skuId: String?
) : Parcelable

@Parcelize
data class DwPromotionInfo(
    @SerializedName("dWPromoDescription")
    val dWPromoDescription: String?,
    @SerializedName("dwToolTipInfo")
    val dwToolTipInfo: String?
): Parcelable
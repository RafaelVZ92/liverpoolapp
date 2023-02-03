package com.rafaelvelazquez.requestmanager.data.mappers

import com.rafaelvelazquez.domain.*
import com.rafaelvelazquez.requestmanager.data.api.ProductsResponse
import javax.inject.Inject

class ProductsModelMapper @Inject constructor(): Mapper<ProductsResponse, ProductsModel> {
    override fun map(input: ProductsResponse): ProductsModel {
        return ProductsModel(
            status = Status(
                input.status?.status,
                input.status?.statusCode
            ),
            pageType = input.pageType,
            plpResults = PlpResults(
                label = input.plpResults?.label,
                plpState = PlpState(
                    input.plpResults?.plpState?.categoryId,
                    input.plpResults?.plpState?.currentFilters,
                    input.plpResults?.plpState?.currentSortOption,
                    input.plpResults?.plpState?.firstRecNum,
                    input.plpResults?.plpState?.lastRecNum,
                    input.plpResults?.plpState?.originalSearchTerm,
                    input.plpResults?.plpState?.plpSellerName,
                    input.plpResults?.plpState?.totalNumRecs,
                    input.plpResults?.plpState?.recsPerPage
                ),
                navigation = Navigation(
                    ancester = input.plpResults?.navigation?.ancester?.map {
                        Ancester(
                            categoryId = it.categoryId,
                            label = it.label
                        )
                    },
                    current = input.plpResults?.navigation?.current?.map {
                        Current(
                            categoryId = it.categoryId,
                            label = it.label
                        )
                    }
                ),
                records = input.plpResults?.records?.map {
                    Record(
                        brand = it.brand,
                        category = it.category,
                        dwPromotionInfo = DwPromotionInfo(
                            dwToolTipInfo = it.dwPromotionInfo.dwToolTipInfo,
                            dWPromoDescription = it.dwPromotionInfo.dWPromoDescription,
                        ),
                        groupType = it.groupType,
                        isExpressFavoriteStore = it.isExpressFavoriteStore,
                        isExpressNearByStore = it.isExpressNearByStore,
                        isHybrid = it.isHybrid,
                        isImportationProduct = it.isImportationProduct,
                        isMarketPlace = it.isMarketPlace,
                        lgImage = it.lgImage,
                        listPrice = it.listPrice,
                        maximumPromoPrice = it.maximumPromoPrice,
                        maximumListPrice = it.maximumListPrice,
                        minimumListPrice = it.minimumListPrice,
                        minimumPromoPrice = it.minimumPromoPrice,
                        productAvgRating = it.productAvgRating,
                        productDisplayName = it.productDisplayName,
                        productId = it.productId,
                        productRatingCount = it.productRatingCount,
                        productType = it.productType,
                        promoPrice = it.promoPrice,
                        promotionalGiftMessage = it.promotionalGiftMessage,
                        seller = it.seller,
                        skuRepositoryId = it.skuRepositoryId,
                        smImage = it.smImage,
                        variantsColor = it.variantsColor?.map { color ->
                            VariantsColor(
                                color.colorHex,
                                color.colorImageURL,
                                color.colorMainURL,
                                color.colorName,
                                color.skuId
                            )
                        },
                        xlImage = it.xlImage
                    )
                },
                refinementGroups = input.plpResults?.refinementGroups?.map {
                    RefinementGroup(
                        dimensionName = it.dimensionName,
                        multiSelect = it.multiSelect,
                        name = it.name,
                        refinement = it.refinement?.map { refinement ->
                            Refinement(
                                colorHex = refinement.colorHex,
                                count = refinement.count,
                                high = refinement.high,
                                label = refinement.label,
                                low = refinement.low,
                                searchName = refinement.searchName,
                                selected = refinement.selected,
                                type = refinement.type,
                                refinementId = refinement.refinementId
                            )
                        }
                    )
                },
                sortOptions = input.plpResults?.sortOptions?.map {
                    SortOption(
                        label = it.label,
                        sortBy = it.sortBy
                    )
                }
            )
        )
    }
}

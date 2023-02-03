package com.rafaelvelazquez.domain

data class ProductsModel(
    val status: Status?,
    val pageType: String?,
    val plpResults: PlpResults?,
)

data class Status(
    val status: String?,
    val statusCode: Int?
)

data class PlpResults(
    val label: String?,
    val plpState: PlpState?,
    val navigation: Navigation?,
    val records: List<Record>?,
    val refinementGroups: List<RefinementGroup>?,
    val sortOptions: List<SortOption>?
)

data class PlpState(
    val categoryId: String?,
    val currentFilters: String?,
    val currentSortOption: String?,
    val firstRecNum: Int?,
    val lastRecNum: Int?,
    val originalSearchTerm: String?,
    val plpSellerName: String?,
    val recsPerPage: Int?,
    val totalNumRecs: Int?
)

data class SortOption(
    val label: String?,
    val sortBy: String?
)

data class Refinement(
    val colorHex: String?,
    val count: Int?,
    val high: String?,
    val label: String?,
    val low: String?,
    val refinementId: String?,
    val searchName: String?,
    val selected: Boolean?,
    val type: String?
)

data class RefinementGroup(
    val dimensionName: String?,
    val multiSelect: Boolean?,
    val name: String?,
    val refinement: List<Refinement>?
)
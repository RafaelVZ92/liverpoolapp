package com.rafaelvelazquez.domain

data class Navigation(
    val ancester: List<Ancester>?,
    val current: List<Current>?
)

data class Ancester(
    val categoryId: String?,
    val label: String?
)

data class Current(
    val categoryId: String?,
    val label: String?
)
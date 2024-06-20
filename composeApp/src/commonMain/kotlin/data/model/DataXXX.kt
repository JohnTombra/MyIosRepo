package com.kind.smartpay20android.data.model.gov

import kotlinx.serialization.Serializable


@Serializable
data class DataXXX(
    val current_page: Int,
    val `data`: List<DataXXXX>,
    val first_page_url: String,
    val from: Int,
    val last_page: Int,
    val last_page_url: String,
    val next_page_url: String?,
    val path: String,
    val per_page: String,
    val prev_page_url: String?,
    val to: Int,
    val total: Int
)
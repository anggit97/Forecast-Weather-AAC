package com.anggitprayogo.forcastmvvm.data.db.entity

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("country")
    val country: String, // Indonesia
    @SerializedName("lat")
    val lat: Double, // -6.21
    @SerializedName("localtime")
    val localtime: String, // 2018-12-21 5:43
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int, // 1545345799
    @SerializedName("lon")
    val lon: Double, // 106.85
    @SerializedName("name")
    val name: String, // Jakarta
    @SerializedName("region")
    val region: String, // Jakarta Raya
    @SerializedName("tz_id")
    val tzId: String // Asia/Jakarta
)
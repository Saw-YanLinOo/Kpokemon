package com.yanyan.kpokemon.data.remote.responses


import com.google.gson.annotations.SerializedName

data class Cries(
    @SerializedName("latest")
    val latest: String?,
    @SerializedName("legacy")
    val legacy: String?
)
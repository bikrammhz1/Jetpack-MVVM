package com.rbmhz.jetpackmvvm.feature.dashboard.data.source.remote

import com.rbmhz.jetpackmvvm.feature.dashboard.data.source.local.BeerEntity

data class BeerDto(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val first_brewed: String,
    val image_url: String?
){
    /**
     * Mapper
     * */
    fun toBeerEntity(): BeerEntity {
        return BeerEntity(
            id = id,
            name = name,
            tagline = tagline,
            description = description,
            firstBrewed = first_brewed,
            imageUrl = image_url
        )
    }
}

package com.rbmhz.jetpackmvvm.feature.dashboard.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rbmhz.jetpackmvvm.feature.dashboard.presentation.state.Beer

@Entity
data class BeerEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val firstBrewed: String,
    val imageUrl: String?
){
    /**
     * Mapper
     * */
    fun toBeer(): Beer {
        return Beer(
            id = id,
            name = name,
            tagline = tagline,
            description = description,
            firstBrewed = firstBrewed,
            imageUrl = imageUrl
        )
    }
}
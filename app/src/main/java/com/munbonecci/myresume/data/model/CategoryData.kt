package com.munbonecci.myresume.data.model

data class CategoryData(
    val label: String,
    val icon: Int,
    val iconContentDescription: String,
    val type: Int
) {
    override fun toString(): String = label
}
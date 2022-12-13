package com.munbonecci.myresume.data.model

data class ContactInfoData(
    val label: String,
    val info: String,
    val icon: Int,
    val iconContentDescription: String,
    val type: Int
) {
    override fun toString(): String = info
}
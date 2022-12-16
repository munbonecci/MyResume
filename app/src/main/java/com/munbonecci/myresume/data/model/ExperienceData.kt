package com.munbonecci.myresume.data.model

data class ExperienceData(
    val companyName: String,
    val companyRole: String,
    val employmentType: String,
    val location: String,
    val description: String,
    val startDate: String,
    val endDate: String,
    val industry: String,
    val companyURL: String,
    val icon: Int,
    val iconContentDescription: String,
    val type: Int
) {
    override fun toString(): String = companyName
}

const val INDUSTRY_RETAIL = "Retail"
const val INDUSTRY_TECH = "Technology"
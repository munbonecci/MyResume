package com.munbonecci.myresume.data.model

data class EducationData(
    val school: String,
    val degree: String,
    val grade: String,
    val fieldOfStudy: String,
    val location: String,
    val description: String,
    val startDate: String,
    val endDate: String,
    val schoolURL: String,
    val icon: Int,
    val iconContentDescription: String,
) {
    override fun toString(): String = school
}
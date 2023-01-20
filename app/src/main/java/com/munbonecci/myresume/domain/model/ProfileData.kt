package com.munbonecci.myresume.domain.model

import com.munbonecci.myresume.R
import com.munbonecci.myresume.data.model.CategoryData

data class ProfileData(
    val profileIcon: Int = R.mipmap.ic_launcher,
    val profileIconContentDescription: String = "",
    val profileName: String = "",
    val headline: String = "",
    val aboutInfo: String = "",
    val profileDialogData: ProfileDialogData = ProfileDialogData(),
    val categories: List<CategoryData> = arrayListOf()
) {
    override fun toString(): String = profileName
}

data class ProfileDialogData(
    val profileName: String = "",
    val headline: String = "",
    val resumeURL: String = "",
    val location: String = "",
    val phone: String = "",
    val email: String = "",
    val profileIcon: Int = R.mipmap.ic_launcher,
    val profileIconContentDescription: String = "",
) {
    override fun toString(): String = profileName
}
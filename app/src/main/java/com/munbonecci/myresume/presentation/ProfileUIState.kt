package com.munbonecci.myresume.presentation

import com.munbonecci.myresume.data.model.Error
import com.munbonecci.myresume.data.model.ProfileData

data class ProfileUIState(
    val isLoading: Boolean = false,
    val profile: ProfileData = ProfileData(),
    val error: Error = Error()
)
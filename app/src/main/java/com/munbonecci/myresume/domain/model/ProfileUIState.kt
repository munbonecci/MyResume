package com.munbonecci.myresume.domain.model

import com.munbonecci.myresume.data.model.Error

data class ProfileUIState(
    val isLoading: Boolean = false,
    val profile: ProfileData = ProfileData(),
    val error: Error = Error()
)
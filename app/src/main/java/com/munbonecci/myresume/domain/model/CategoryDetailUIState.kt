package com.munbonecci.myresume.domain.model

import com.munbonecci.myresume.data.model.Error

data class CategoryDetailUIState(
    val isLoading: Boolean = false,
    val profile: CategoryDetailData = CategoryDetailData(),
    val error: Error = Error()
)
package com.munbonecci.myresume.presentation.detail_screen

import com.munbonecci.myresume.data.model.Error
import com.munbonecci.myresume.domain.model.CategoryDetailData

data class CategoryDetailUIState(
    val isLoading: Boolean = false,
    val profile: CategoryDetailData = CategoryDetailData(),
    val error: Error = Error()
)
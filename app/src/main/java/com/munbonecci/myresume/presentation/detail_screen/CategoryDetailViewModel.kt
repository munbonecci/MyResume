package com.munbonecci.myresume.presentation.detail_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.munbonecci.myresume.commons.Resource
import com.munbonecci.myresume.data.model.Error
import com.munbonecci.myresume.domain.model.CategoryDetailUIState
import com.munbonecci.myresume.domain.use_case.CategoryDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(private val getCategoryDetailUseCase: CategoryDetailUseCase) :
    ViewModel() {
    private val _uiCategoryDetailState = MutableStateFlow(CategoryDetailUIState())
    val uiCategoryDetailState: StateFlow<CategoryDetailUIState> =
        _uiCategoryDetailState.asStateFlow()

    fun getCategorySelectedData(categoryId: Int) {
        getCategoryDetailUseCase(categoryId = categoryId).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _uiCategoryDetailState.value =
                        CategoryDetailUIState(error = Error(errorMessage = result.message ?: ""))
                }
                is Resource.Loading -> {
                    _uiCategoryDetailState.value = CategoryDetailUIState(isLoading = true)
                }
                is Resource.Success -> {
                    result.data?.let { data ->
                        _uiCategoryDetailState.value = CategoryDetailUIState(category = data)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}
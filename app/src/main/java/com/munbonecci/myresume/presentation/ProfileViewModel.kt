package com.munbonecci.myresume.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.munbonecci.myresume.commons.Resource
import com.munbonecci.myresume.data.model.Error
import com.munbonecci.myresume.domain.model.ProfileUIState
import com.munbonecci.myresume.domain.use_case.ProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val getProfileUseCase: ProfileUseCase) :
    ViewModel() {
    private val _uiProfileState = MutableStateFlow(ProfileUIState())
    val uiProfileState: StateFlow<ProfileUIState> = _uiProfileState.asStateFlow()

    init {
        getProfileInfo()
    }

    private fun getProfileInfo() {
        getProfileUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _uiProfileState.value =
                        ProfileUIState(error = Error(errorMessage = result.message ?: ""))
                }
                is Resource.Loading -> {
                    _uiProfileState.value = ProfileUIState(isLoading = true)
                }
                is Resource.Success -> {
                    result.data?.let { data ->
                        _uiProfileState.value = ProfileUIState(profile = data)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}
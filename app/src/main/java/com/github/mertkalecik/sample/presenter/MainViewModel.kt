package com.github.mertkalecik.sample.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mertkalecik.sample.data.State
import com.github.mertkalecik.sample.data.entity.BannerUIModel
import com.github.mertkalecik.sample.domain.BannerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val bannerUseCase: BannerUseCase
): ViewModel() {

    private val _state = MutableStateFlow<State>(State.Loading)
    val state = _state.asStateFlow()

    init {
        getBanners()
    }

    private fun getBanners() {
        viewModelScope.launch {
            bannerUseCase.run(Unit).collect {
                _state.value = it
            }
        }
    }

    fun onBannerClick(uiModel: BannerUIModel) {
        // TODO implement click
    }
}
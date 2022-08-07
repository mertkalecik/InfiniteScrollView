package com.mertkalecik.infinitescrollview.data

import com.mertkalecik.infinitescrollview.data.entity.BannerUIModel

sealed class State {
    object Loading: State()

    data class Content(val bannerList: List<BannerUIModel>) : State()

    data class Error(val t: Throwable): State()
}

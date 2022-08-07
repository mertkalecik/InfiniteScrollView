package com.mertkalecik.infinitescrollview.domain

import com.mertkalecik.infinitescrollview.base.UseCase
import com.mertkalecik.infinitescrollview.data.State
import com.mertkalecik.infinitescrollview.data.repository.BannerProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext
import javax.inject.Inject


class BannerUseCase @Inject constructor() : UseCase<Unit, Flow<State>> {

    override suspend fun run(input: Unit) = withContext(Dispatchers.IO) {
        flowOf(State.Content(bannerList = BannerProvider.getBanners()))
    }

}
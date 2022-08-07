package com.github.mertkalecik.sample.domain

import com.github.mertkalecik.sample.base.UseCase
import com.github.mertkalecik.sample.data.State
import com.github.mertkalecik.sample.data.repository.BannerProvider
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
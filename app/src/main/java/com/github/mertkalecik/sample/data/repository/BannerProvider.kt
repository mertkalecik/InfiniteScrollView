package com.github.mertkalecik.sample.data.repository

import com.github.mertkalecik.sample.data.entity.BannerUIModel

object BannerProvider {

    fun getBanners() = listOf(
        BannerUIModel(
            title = "Test1",
            imageURL = "https://images.unsplash.com/photo-1504805572947-34fad45aed93?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Y292ZXIlMjBwaG90b3xlbnwwfHwwfHw%3D&w=1000&q=80"
        ),
        BannerUIModel(
            title = "Test2",
            imageURL = "https://i.pinimg.com/474x/2c/84/0e/2c840e86d494c5e809f850b00a69ad29--cover-photos-twitter-facebook-header-cover-photos.jpg"
        ),
        BannerUIModel(
            title = "Test3",
            imageURL = "https://i.pinimg.com/originals/89/c9/6e/89c96e617c97499520e7ae52eb1cb930.jpg"
        )
    )
}
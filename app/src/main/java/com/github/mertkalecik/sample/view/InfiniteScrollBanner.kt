package com.github.mertkalecik.sample.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.github.mertkalecik.sample.data.State
import com.github.mertkalecik.sample.data.entity.BannerUIModel
import com.mertkalecik.infinitescrollview.InfiniteScrollView

@Composable
fun BannerView(
    content: State.Content,
    onBannerClick: (BannerUIModel) -> Unit
) {
    content.bannerList.takeIf { it.isNotEmpty() }.let {
        InfiniteScrollView(
            list = content.bannerList,
            paddingValues = PaddingValues(top = 16.dp, start = 32.dp, end = 32.dp),
            selectedColor = Color.Red
        ) { banner ->
            BannerViewContent(uiModel = banner, onClick = onBannerClick)
        }
    }
}

@Composable
private fun BannerViewContent(
    uiModel: BannerUIModel,
    onClick: (BannerUIModel) -> Unit
) {
    Layout(
        modifier = Modifier
            .padding(start = 4.dp, end = 4.dp)
            .clickable { onClick(uiModel) },
        shape = RoundedCornerShape(8.dp),
        color = Color.Transparent,
        elevation = 3.dp
    ) {
        Image(
            painter = rememberAsyncImagePainter(uiModel.imageURL),
            contentDescription = uiModel.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(320F / 148F)
        )
    }
}
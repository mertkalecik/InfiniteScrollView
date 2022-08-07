package com.mertkalecik.infinitescrollview

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@Composable
@OptIn(ExperimentalPagerApi::class)
fun <T> InfiniteScrollView(
    list: List<T>,
    paddingValues: PaddingValues,
    itemSpacing: Dp = 8.dp,
    indicatorSpacing: Dp = 8.dp,
    infiniteScrollEnabled: Boolean = true,
    dotIndicatorEnabled: Boolean = true,
    selectedColor: Color = Color.Green,
    unSelectedColor: Color = Color.LightGray,
    content: @Composable (T) -> Unit
) {
    val scrollItems by remember { mutableStateOf(list) }
    val pagerState = rememberPagerState()
    val itemSize = scrollItems.size
    val isScrollable = itemSize > 1

    HorizontalPager(
        count = if (infiniteScrollEnabled && isScrollable) Int.MAX_VALUE else itemSize,
        state = pagerState,
        contentPadding = paddingValues,
        itemSpacing = itemSpacing
    ) { page ->
        val index = page % itemSize
        content(list[index])
    }

    if (isScrollable && dotIndicatorEnabled) {
        Spacer(Modifier.padding(vertical = indicatorSpacing))
        DotsIndicator(
            currentPage = pagerState.currentPage % itemSize,
            currentPageOffset = pagerState.currentPageOffset,
            totalDots = itemSize,
            selectedColor = selectedColor,
            unSelectedColor = unSelectedColor
        )
        Spacer(Modifier.padding(vertical = indicatorSpacing))
    }
}
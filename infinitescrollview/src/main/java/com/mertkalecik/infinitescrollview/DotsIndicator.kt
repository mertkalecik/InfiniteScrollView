package com.mertkalecik.infinitescrollview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp


@Composable
internal fun DotsIndicator(
    currentPage: Int,
    currentPageOffset: Float,
    totalDots: Int,
    selectedColor: Color = Color.Green,
    unSelectedColor: Color = Color.LightGray,
    itemSpacing: Dp = 8.dp,
    indicatorWidth: Dp = 10.dp
) = LazyRow(
    modifier = Modifier.fillMaxWidth().wrapContentHeight(),
    horizontalArrangement = Arrangement.Center
) {
    item {
        Box(
            modifier = Modifier,
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                repeat(totalDots) {
                    Box(
                        Modifier.size(indicatorWidth)
                            .background(color = unSelectedColor, shape = CircleShape)
                    )
                }
            }

            DotIndicator(
                currentPage = currentPage,
                currentPageOffset = currentPageOffset,
                totalDots = totalDots,
                selectedColor = selectedColor,
                indicatorWidth = indicatorWidth,
                itemSpacing = itemSpacing
            )
        }
    }
}

@Composable
private fun DotIndicator(
    currentPage: Int,
    currentPageOffset: Float,
    totalDots: Int,
    selectedColor: Color,
    indicatorWidth: Dp,
    itemSpacing: Dp
) {
    val indicatorWidthPx = LocalDensity.current.run { indicatorWidth.roundToPx() }
    val spacingPx = LocalDensity.current.run { itemSpacing.roundToPx() }
    var scrollPosition by remember { mutableStateOf(0F) }

    Box(
        modifier = Modifier.offset {
            scrollPosition = (currentPage + currentPageOffset)
                .coerceIn(0F, (totalDots - 1).coerceAtLeast(0).toFloat())

            IntOffset(
                x = ((spacingPx + indicatorWidthPx) * scrollPosition).toInt(),
                y = 0
            )
        }.background(color = selectedColor, CircleShape).size(indicatorWidth)
    )
}

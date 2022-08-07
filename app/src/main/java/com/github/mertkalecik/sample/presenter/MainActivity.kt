package com.github.mertkalecik.sample.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.mertkalecik.sample.ui.theme.InfiniteScrollViewTheme
import com.github.mertkalecik.sample.view.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InfiniteScrollViewTheme {
                MainScreen()
            }
        }
    }
}
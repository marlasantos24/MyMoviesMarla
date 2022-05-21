package com.marla.mymoviesms.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.marla.mymoviesms.ui.theme.MyMoviesMsTheme

@Composable
fun MyMoviesApp(content: @Composable () -> Unit) {
    MyMoviesMsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ){
            content(
            )
        }
    }
}
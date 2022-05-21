package com.marla.mymoviesms.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@ExperimentalFoundationApi
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            MainAppBar()
        }
    ) { padding ->
        MediaList( navController ,modifier = Modifier.padding(padding))
    }
}
package com.marla.mymoviesms.ui.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.marla.mymoviesms.R
import com.marla.mymoviesms.model.getMedia
import com.marla.mymoviesms.ui.screens.common.Thumb

@Composable
//@Preview(showBackground = true, width = 400, height = 400)
fun DetailScreen(mediaId:Int){
    val mediaItem = remember { getMedia().first{ it.id == mediaId } }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text=mediaItem.title)
            })
        }
    ){
        Thumb(mediaItem)
    }

    /*
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Detail Screen $mediaId",
            style = MaterialTheme.typography.h4
        )
    }*/
}
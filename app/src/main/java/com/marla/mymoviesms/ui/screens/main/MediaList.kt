package com.marla.mymoviesms.ui.screens.main

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.marla.mymoviesms.model.MediaItem
import com.marla.mymoviesms.model.getMedia
import com.marla.mymoviesms.R
@ExperimentalFoundationApi
//@Preview
@Composable
fun MediaList(navController: NavHostController, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_xsmall)),
        cells = GridCells.Adaptive(dimensionResource(R.dimen.cell_min_width)),
        modifier = modifier
    ){

        items(getMedia()){ item ->
            MediaListItem(
                item,
                navController,
                Modifier.padding(dimensionResource(R.dimen.padding_xsmall)),
            )
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun MediaListItem(
    item: MediaItem,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.clickable{
            navController.navigate("detail/${item.id}")
        } ,
        elevation = 0.dp,
        shape = RoundedCornerShape(9.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.Black

    ){
        Column{
            Box(
                modifier = Modifier
                    .height(dimensionResource(R.dimen.cell_thumb_height))
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = item.thumb,
                    ),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                if(item.type == MediaItem.Type.VIDEO) {
                    Icon(
                        imageVector = Icons.Default.PlayCircleOutline,
                        contentDescription = null,
                        modifier = Modifier.size(dimensionResource(R.dimen.cell_play_icon_size)),
                        tint = Color.White,
                    )
                }
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    //.background(MaterialTheme.colors.secondary)
                    .padding(dimensionResource(R.dimen.padding_medium))
            ){
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.h6,
                )
            }

        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun MediaListPreview(){
    MediaList()
}

fun MediaList() {
    TODO("Not yet implemented")
}

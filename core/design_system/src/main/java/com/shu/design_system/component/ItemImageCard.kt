package com.shu.design_system.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun ItemImageCard(
    image: String,
    title: String = "",
    onItemClick: () -> Unit,
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .padding(4.dp)
            .width(300.dp)
            .height(220.dp)
            .clickable { onItemClick() },

        ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(image).build(),
                contentDescription = "picture",
                contentScale = ContentScale.FillBounds,
            )

            /* Text(
                 text = title,
                 lineHeight = 15.sp,
                 fontSize = 14.sp,
                 modifier = Modifier
                     .testTag("title")
                     .fillMaxWidth()
                     .background(Color.Transparent.copy(alpha = 0.3f))
                     .align(Alignment.BottomCenter)
                     .padding(bottom = 4.dp),
                 color = Color.White,
                 textAlign = TextAlign.Center
             )

             Text(
                 text = "$id",
                 lineHeight = 12.sp,
                 fontSize = 12.sp,
                 modifier = Modifier
                     .testTag("id")
                     .fillMaxWidth()
                     .background(Color.Transparent.copy(alpha = 0.3f))
                     .align(Alignment.TopCenter)
                     .padding(bottom = 4.dp),
                 color = Color.White,
                 textAlign = TextAlign.Center
             )*/
        }
    }
}
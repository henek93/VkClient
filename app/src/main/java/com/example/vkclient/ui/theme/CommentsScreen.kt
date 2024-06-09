package com.example.vkclient.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkclient.R
import com.example.vkclient.domain.FeedPost


@Composable
fun CommentScreen(
    feedPost: FeedPost
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Comments for FeedPosts Id: ${feedPost.id}")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                backgroundColor = Color.White
            )
        }
    ) {paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
        ) {

        }
    }
}

@Preview
@Composable
fun Comment() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(4.dp),
        horizontalArrangement = Arrangement.Absolute.Left,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.post_comunity_thumbnail),
            contentDescription = "Icon author",
            modifier = Modifier
                .clip(CircleShape)
                .size(35.dp)

        )
        Column(
            modifier = Modifier
                .padding(4.dp)
        ) {
            Text(
                text = "Author comment",
                fontSize = 10.sp,
                color = Color.DarkGray,
                modifier = Modifier
                    .padding(2.dp)
            )

            Text(
                text = "LongComment text",
                fontSize = 12.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 2.dp)
            )
            Text(
                text = "14:00",
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(2.dp)
            )
        }
    }
}
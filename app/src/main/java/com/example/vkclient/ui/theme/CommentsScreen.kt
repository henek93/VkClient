package com.example.vkclient.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vkclient.CommentsViewModel
import com.example.vkclient.CommentsViewModelFactory
import com.example.vkclient.domain.FeedPost
import com.example.vkclient.domain.PostComment


@Composable
fun CommentScreen(
    onBackPressed: () -> Unit,
    feedPost: FeedPost
) {
    val viewModel: CommentsViewModel = viewModel(
        factory = CommentsViewModelFactory(feedPost)
    )

    viewModel.loadComments(FeedPost())
    val screenState = viewModel.screenState.observeAsState(CommentScreenState.Initial)
    val currentState = screenState.value

    if (currentState is CommentScreenState.Comments) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Comments for FeedPosts Id: ${feedPost.id}")
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            onBackPressed()
                        }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = null
                            )
                        }
                    },
                    backgroundColor = Color.White
                )
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues),
                contentPadding = PaddingValues(
                    top = 16.dp,
                    start = 8.dp,
                    end = 8.dp,
                    bottom = 72.dp
                )
            ) {
                items(
                    items = currentState.comments,
                    key = { it.id }
                ) { comment ->
                    CommentItem(comment = comment)
                }
            }
        }
    }
}

@Composable
fun CommentItem(
    comment: PostComment
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(4.dp),
        horizontalArrangement = Arrangement.Absolute.Left,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = comment.authorAvatarId),
            contentDescription = "Icon author",
            modifier = Modifier
                .clip(CircleShape)
                .size(44.dp)

        )
        Column(
            modifier = Modifier
                .padding(4.dp)
        ) {
            Text(
                text = comment.name,
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier
                    .padding(2.dp)
            )

            Text(
                text = comment.commentText,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 2.dp)
            )
            Text(
                text = comment.publicationDate,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(2.dp)
            )
        }
    }
}
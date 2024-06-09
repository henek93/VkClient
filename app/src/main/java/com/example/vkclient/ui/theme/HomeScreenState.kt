package com.example.vkclient.ui.theme

import com.example.vkclient.domain.FeedPost
import com.example.vkclient.domain.PostComment

sealed class HomeScreenState {

    object Initial: HomeScreenState()

    data class Posts(val posts: List<FeedPost>): HomeScreenState()
    data class Comments(val feedPost: FeedPost, val comments: List<PostComment>): HomeScreenState()


}
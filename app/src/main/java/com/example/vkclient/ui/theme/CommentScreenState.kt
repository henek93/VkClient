package com.example.vkclient.ui.theme

import com.example.vkclient.domain.FeedPost
import com.example.vkclient.domain.PostComment

sealed class CommentScreenState {

    object Initial : CommentScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentScreenState()


}
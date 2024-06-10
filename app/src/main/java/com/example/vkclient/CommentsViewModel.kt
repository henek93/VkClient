package com.example.vkclient

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vkclient.domain.FeedPost
import com.example.vkclient.domain.PostComment
import com.example.vkclient.ui.theme.CommentScreenState

class CommentsViewModel(feedPost: FeedPost) : ViewModel() {

    private val _screenState = MutableLiveData<CommentScreenState>(CommentScreenState.Initial)
    val screenState: LiveData<CommentScreenState> = _screenState


    init {
        loadComments(FeedPost())
    }

    fun loadComments(feedPost: FeedPost) {
        val comments = mutableListOf<PostComment>().apply {
            repeat(10) {
                add(PostComment(id = it))
            }
        }
        _screenState.value = CommentScreenState.Comments(
            feedPost = feedPost,
            comments = comments
        )
    }
}
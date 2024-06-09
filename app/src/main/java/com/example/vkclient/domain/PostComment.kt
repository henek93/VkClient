package com.example.vkclient.domain

import com.example.vkclient.R

data class PostComment(
    val id: Int,
    val name: String = "Author",
    val authorAvatarId: Int = R.drawable.comment_author_avatar,
    val commentText: String = "Long comment text",
    val publicationDate: String = "14:00"
)
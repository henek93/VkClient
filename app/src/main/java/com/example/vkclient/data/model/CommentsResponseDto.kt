package com.example.vkclient.data.model

import com.example.vkclient.data.model.CommentsContentDto
import com.google.gson.annotations.SerializedName

data class CommentsResponseDto(
    @SerializedName("response") val content: CommentsContentDto
)

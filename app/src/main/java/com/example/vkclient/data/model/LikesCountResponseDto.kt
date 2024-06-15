package com.example.vkclient.data.model

import com.example.vkclient.data.model.LikesCountDto
import com.google.gson.annotations.SerializedName

data class LikesCountResponseDto(
    @SerializedName("response") val likes: LikesCountDto
)

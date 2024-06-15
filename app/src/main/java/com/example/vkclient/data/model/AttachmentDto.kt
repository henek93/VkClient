package com.example.vkclient.data.model

import com.google.gson.annotations.SerializedName
import com.example.vkclient.data.model.PhotoDto

data class AttachmentDto(
    @SerializedName("photo") val photo: PhotoDto?
)

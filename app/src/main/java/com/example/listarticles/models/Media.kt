package com.example.listarticles.models

import MediaMeta
import com.google.gson.annotations.SerializedName

data class Media (
    @SerializedName ("media-metadata")
    val mediameta : List<MediaMeta>
 )
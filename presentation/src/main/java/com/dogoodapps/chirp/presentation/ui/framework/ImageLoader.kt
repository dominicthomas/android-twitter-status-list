package com.dogoodapps.chirp.presentation.ui.framework

import android.widget.ImageView

interface ImageLoader {
    fun load(path: String?): ImageLoader

    fun into(imageView: ImageView)
}
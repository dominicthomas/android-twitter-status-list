package com.dogoodapps.statuslist.presentation.ui.framework

import android.widget.ImageView
import com.squareup.picasso.Picasso
import javax.inject.Inject

class PicassoWrapper @Inject constructor(private val picasso: Picasso) : ImageLoader {

    private var imageUrl: String? = null

    override fun load(path: String?): ImageLoader {
        imageUrl = path
        return this
    }

    override fun into(imageView: ImageView) {
        imageUrl.let {
            picasso.load(imageUrl).into(imageView)
        }
    }
}
package com.krayapp.gitproject.data.imageloader

import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageLoaderImpl:IImageLoader<ImageView> {
    override fun loadInto(url: String, container: ImageView) {
        Glide.with(container.context)
            .load(url)
            .into(container)
    }
}
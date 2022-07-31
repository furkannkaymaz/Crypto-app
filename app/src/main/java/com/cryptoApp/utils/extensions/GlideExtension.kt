package com.cryptoApp.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

fun ImageView.loadImage(url: String){
    Glide.with(this)
        .load(url)
        .centerCrop()
        .transform(FitCenter(), RoundedCorners(25))
        .into(this)
}
package com.example.inovantsolutionstask.home.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import java.io.File

object ImageSetter {
    enum class LoadImageType {
        ROUND, NONE
    }

    fun loadImage(mUrl: String?, placeHolder: Int, mImageView: ImageView) {
        if (!mUrl.isNullOrEmpty()) {
            Picasso.get().load(mUrl)
                .placeholder(placeHolder)
                .into(mImageView)
        } else {
            mImageView.setImageResource(placeHolder)
        }
    }

    fun loadImage(file: File?, placeHolder: Int, mImageView: ImageView): Boolean {
        return if (file != null) {
            Picasso.get().load(file)
                .placeholder(placeHolder)
                .into(mImageView)
            true
        } else {
            mImageView.setImageResource(placeHolder)
            false
        }
    }

    fun loadRoundedImage(mUrl: String?, placeHolder: Int, mImageView: ImageView) {
        if (!mUrl.isNullOrEmpty()) {
            Picasso.get().load(mUrl)
                .transform(CircleTransform())
                .placeholder(placeHolder)
                .error(placeHolder)
                .into(mImageView)
        } else {
            mImageView.setImageResource(placeHolder)
        }
    }

    fun loadRoundedImage(file: File?, placeHolder: Int, mImageView: ImageView): Boolean {
        return if (file != null) {
            Picasso.get().load(file)
                .transform(CircleTransform())
                .placeholder(placeHolder)
                .error(placeHolder)
                .into(mImageView)
            true
        } else {
            mImageView.setImageResource(placeHolder)
            false
        }
    }

}

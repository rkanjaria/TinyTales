package com.rk.tinytales.core.presentation.util

import android.content.Context
import coil.request.ImageRequest
import com.rk.tinytales.R


fun load(
    context: Context,
    url: String?,
    placeholder: Int = R.drawable.bg_placeholder
): ImageRequest {
    return ImageRequest.Builder(context)
        .data(url)
        .memoryCacheKey(url)
        .diskCacheKey(url)
        .crossfade(true)
        .placeholder(placeholder)
        .error(placeholder)
        .fallback(placeholder)
        .build()
}
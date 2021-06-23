package com.amiir.baloot.util.bindingAdapter

import android.content.res.Resources


fun Resources.pixelsToSp(px: Float): Float = px / displayMetrics.scaledDensity
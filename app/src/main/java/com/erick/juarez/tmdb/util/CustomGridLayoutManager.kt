package com.erick.juarez.tmdb.util

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager

class CustomGridLayoutManager constructor(ctx: Context?): GridLayoutManager(ctx, 2) {
    override fun supportsPredictiveItemAnimations(): Boolean {
        return false
    }
}
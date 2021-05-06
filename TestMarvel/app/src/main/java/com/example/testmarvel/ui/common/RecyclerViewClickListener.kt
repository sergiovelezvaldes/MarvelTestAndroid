package com.example.testmarvel.ui.common

import android.view.View

interface RecyclerViewClickListener {
    fun <T> onRecyclerViewItemClick(view: View, item: T)
}
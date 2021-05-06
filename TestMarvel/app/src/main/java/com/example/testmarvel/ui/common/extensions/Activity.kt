package com.example.testmarvel.ui.common.extensions

import android.app.Activity
import com.example.testmarvel.MarvelApp

val Activity.app: MarvelApp
    get() = application as MarvelApp
package com.example.testmarvel.ui.common.extensions

fun String.replaceByUrlSecure(): String = this.replace("http", "https")
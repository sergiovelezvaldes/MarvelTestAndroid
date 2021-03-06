package com.example.testmarvel.ui.common.extensions

import android.app.AlertDialog
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.testmarvel.MarvelApp
import com.example.testmarvel.R
import retrofit2.http.Url


val Fragment.app: MarvelApp
    get() = requireActivity().application as MarvelApp

fun Fragment.hideKeyboard() {
    (requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
        .hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
}

fun Fragment.download(
    imageView: ImageView,
    url: String
) {
    Glide.with(this)
        .load(url)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
        .into(imageView)
}

fun Fragment.alert(title: String = "Oops", description: String = "We couldn't find information to you, please try again later"): AlertDialog =
    AlertDialog.Builder(this.context)
        .setTitle(title)
        .setMessage(description)
        .setPositiveButton(R.string.Ok) { view, _ ->
            view.dismiss()
        }
        .create()

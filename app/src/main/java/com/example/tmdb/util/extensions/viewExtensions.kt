package com.example.tmdb.util.extensions

import android.view.View

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.collapse() {
    visibility = View.GONE
}
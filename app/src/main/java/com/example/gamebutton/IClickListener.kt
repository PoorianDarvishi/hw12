package com.example.gamebutton

import android.view.View

interface IClickListener {
    fun setOnClickListener(number: Int, view: View)
}
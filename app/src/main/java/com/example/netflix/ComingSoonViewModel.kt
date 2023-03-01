package com.example.netflix

import androidx.lifecycle.ViewModel

class ComingSoonViewModel: ViewModel() {
    private val imageList = mutableListOf(
        ImageComingSoon("Sponge Bob1", R.drawable.spong_bob, "R.drawable.spong_bob"),
        ImageComingSoon("Sponge Bob2", R.drawable.spong_bob, "R.drawable.spong_bob"),
        ImageComingSoon("Sponge Bob3", R.drawable.spong_bob, "R.drawable.spong_bob"),
    )
    fun addImage(nameImage: String, src: Int) {
        imageList.add(ImageComingSoon(nameImage, src, src.toString()))
    }
    fun getImages(): MutableList<ImageComingSoon> {
        return imageList
    }
}
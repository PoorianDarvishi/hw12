package com.example.netflix.image

import androidx.lifecycle.ViewModel
import com.example.netflix.R

class ImagesViewModel : ViewModel() {
    private val imageList = mutableListOf(
        Image("Sponge Bob1", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob2", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob3", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob4", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob5", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob6", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob7", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob8", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob9", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob10", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob11", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob12", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob13", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob14", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob15", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob16", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob17", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob18", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob19", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob20", R.drawable.spong_bob, "R.drawable.spong_bob", false),
        Image("Sponge Bob21", R.drawable.spong_bob, "R.drawable.spong_bob", false),
    )

    private val likeList = arrayListOf<Image>()

    fun addImage(nameImage: String, src: Int) {
        imageList.add(Image(nameImage, src, src.toString(), false))
    }

    fun getImages(): MutableList<Image> {
        return imageList
    }


    private fun like(position: Int) {
        likeList.add(imageList[position])
        imageList[position].isLike = true
    }

    private fun disLike(position: Int) {
        likeList.remove(imageList[position])
        imageList[position].isLike = false
    }

    fun click(position: Int) {
        if (imageList[position].isLike) {
            disLike(position)
        } else {
            like(position)
        }
    }

    fun getLikeList(): ArrayList<Image> {
        return likeList
    }
}
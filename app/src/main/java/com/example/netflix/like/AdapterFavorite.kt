package com.example.netflix.like

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.netflix.image.Image
import com.example.netflix.R

class AdapterFavorite(private val item: MutableList<Image>) :
    RecyclerView.Adapter<AdapterFavorite.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemText: TextView = itemView.findViewById(R.id.tv_home)
        val itemHome: AppCompatImageView = itemView.findViewById(R.id.iv_home)
        val itemLike: AppCompatImageButton = itemView.findViewById(R.id.iv_like)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_re, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            itemText.text = item[position].nameImage
            itemHome.setImageResource(item[position].imageSRC)
            itemLike.setImageResource(R.drawable.round_favorite_24)
        }
    }


    override fun getItemCount(): Int {
        return item.size
    }
}



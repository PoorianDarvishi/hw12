package com.example.netflix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView

class AdapterComingSoon(
    private val item: MutableList<ImageComingSoon>,
    private val clickListener: IComingSoonClick
) :
    RecyclerView.Adapter<AdapterComingSoon.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemText: TextView = itemView.findViewById(R.id.tv_home)
        val itemHome: AppCompatImageView = itemView.findViewById(R.id.iv_home)
        val itemShare: AppCompatImageButton = itemView.findViewById(R.id.iv_share)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.coming_soon_item_re, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            itemText.text = item[position].nameImage
            itemHome.setImageResource(item[position].imageSRC)
            itemShare.setOnClickListener{
                clickListener.onClick(position)
            }
        }
    }


    override fun getItemCount(): Int {
        return item.size
    }
}
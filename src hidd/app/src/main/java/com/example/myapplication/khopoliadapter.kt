package com.example.myapplication

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Khopoliadapter(
    val listener: MyClickListener,
    val context: Context,
    val location: List<placeambernath>,
    val img: List<Int>,
    val ratings: List<String>,
) : RecyclerView.Adapter<Khopoliadapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgKhopoli = itemView.findViewById<ImageView>(R.id.placeimage)
        val txvtitleKhopoli = itemView.findViewById<TextView>(R.id.placename)
        val ratings = itemView.findViewById<TextView>(R.id.rating)
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.khopoli_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val locate = location[position]
        val formattedText = Html.fromHtml(locate.title, Html.FROM_HTML_MODE_LEGACY)
        holder.txvtitleKhopoli.text = formattedText
        holder.ratings.text = ratings[position]
        Glide.with(context)
            .load(img[position]) // Load image from the img list
            .into(holder.imgKhopoli)
    }

    override fun getItemCount(): Int {
        return location.size
    }

    interface MyClickListener {
        fun onClick(position: Int)
    }
}

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

class ghatkoparadapter(
    val listener: MyClickListener,
    val context: Context,
    val location: List<placekalyan>,
    val img: List<Int>,
    val ratings: List<String>,
) : RecyclerView.Adapter<ghatkoparadapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgAmbernath: ImageView = itemView.findViewById(R.id.placeimage)
        val txvtitleAmbernath: TextView = itemView.findViewById(R.id.placename)
        val rating = itemView.findViewById<TextView>(R.id.rating)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.neral_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val locate = location[position]

        // Applying HTML formatting to the text
        holder.txvtitleAmbernath.text = Html.fromHtml(locate.title)

        holder.rating.text = ratings[position]
        // Using Glide to load image into ImageView
        Glide.with(context)
            .load(img[position]) // Load image from the img list
            .into(holder.imgAmbernath) // Set the loaded image into ImageView
    }

    override fun getItemCount(): Int {
        return location.size
    }

    interface MyClickListener {
        fun onClick(position: Int)
    }
}

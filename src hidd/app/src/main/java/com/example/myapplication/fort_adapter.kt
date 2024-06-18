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

class fortadapter(
    val context: Context,
    val location: List<String>,
    val img: List<Int>,
    val ratings: List<String>,
    val info: List<String>,
    val listener: MyClickListener
) : RecyclerView.Adapter<fortadapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgThane = itemView.findViewById<ImageView>(R.id.fortimg)
        val txvtitleThane = itemView.findViewById<TextView>(R.id.titlefort)
        val data = itemView.findViewById<TextView>(R.id.descriptionfort)
        val rating = itemView.findViewById<TextView>(R.id.ratingfort)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fort_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val locationName = location[position]
        val formattedLocationName = Html.fromHtml(locationName, Html.FROM_HTML_MODE_LEGACY)
        holder.txvtitleThane.text = formattedLocationName

        val infoText = info[position]
        val formattedInfoText = Html.fromHtml(infoText, Html.FROM_HTML_MODE_LEGACY)
        holder.data.text = formattedInfoText

        holder.rating.text = ratings[position]
        Glide.with(context)
            .load(img[position])
            .into(holder.imgThane)
    }

    override fun getItemCount(): Int {
        return location.size
    }

    interface MyClickListener {
        fun onClick(position: Int)
    }
}

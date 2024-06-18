// fortadapter.kt
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

class cafeadapter(
    val context: Context,
    val location: List<String>,
    val img: List<Int>,
    val ratings: List<String>,
    val info: List<String>,
    val listener: cafemain // Add listener parameter){}
) : RecyclerView.Adapter<cafeadapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgThane = itemView.findViewById<ImageView>(R.id.cafeimg)
        val txvtitleThane = itemView.findViewById<TextView>(R.id.titlecafe)
        val data = itemView.findViewById<TextView>(R.id.descriptioncafe)
        val rating = itemView.findViewById<TextView>(R.id.ratingcafe)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cafe_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val locate = location[position]
        val formattedTitle = Html.fromHtml(locate, Html.FROM_HTML_MODE_LEGACY)
        val infoText = info[position]
        val formattedInfoText = Html.fromHtml(infoText, Html.FROM_HTML_MODE_LEGACY)

        holder.txvtitleThane.text = formattedTitle
        holder.data.text = formattedInfoText  // Set the description with info text
        holder.rating.text = ratings[position]
        Glide.with(context)
            .load(img[position]) // Load image from the img list
            .into(holder.imgThane)
    }


    override fun getItemCount(): Int {
        return location.size
    }

    interface MyClickListener {
        fun onClick(position: Int)
    }
}

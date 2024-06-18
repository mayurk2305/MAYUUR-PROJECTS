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

class CsmtAdapter(
    val listener: MyClickListener,
    val context: Context,
    val location: List<placecsmt>,
    val img: List<Int>,
    val ratings: List<String>
) : RecyclerView.Adapter<CsmtAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCsmt = itemView.findViewById<ImageView>(R.id.placeimage)
        val txvTitleCsmt = itemView.findViewById<TextView>(R.id.placename)
        val rating = itemView.findViewById<TextView>(R.id.rating)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.csmt_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return location.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val locate = location[position]
        val formattedText = Html.fromHtml(locate.title, Html.FROM_HTML_MODE_LEGACY)
        holder.txvTitleCsmt.text = formattedText
        holder.rating.text = ratings[position]
        Glide.with(context)
            .load(img[position]) // Load image from the img list
            .into(holder.imgCsmt)
    }

    interface MyClickListener {
        fun onClick(position: Int)
    }
}

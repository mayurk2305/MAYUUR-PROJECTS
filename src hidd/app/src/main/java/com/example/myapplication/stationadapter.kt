package com.example.myapplicationimport android.content.Contextimport android.text.Htmlimport android.view.LayoutInflaterimport android.view.Viewimport android.view.ViewGroupimport android.widget.ImageViewimport android.widget.TextViewimport androidx.recyclerview.widget.RecyclerViewimport com.bumptech.glide.Glideclass StationAdapter(    private val context: Context,    private val locations: List<Stations>,    private val images: Array<Int>,    private val listener: MyClickListener) : RecyclerView.Adapter<StationAdapter.MyViewHolder>() {    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {        val imgAmbernath: ImageView = itemView.findViewById(R.id.station)        val txvtitleAmbernath: TextView = itemView.findViewById(R.id.stnname)        init {            itemView.setOnClickListener {                val position = adapterPosition                listener.onClick(position)            }        }    }    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {        val view = LayoutInflater.from(context).inflate(R.layout.list_view, parent, false)        return MyViewHolder(view)    }    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {        val location = locations[position]        // Applying HTML formatting to the text        holder.txvtitleAmbernath.text = Html.fromHtml(location.title)        // Using Glide to load image into ImageView        Glide.with(context)            .load(images[position])            .into(holder.imgAmbernath)    }    override fun getItemCount(): Int {        return locations.size    }    interface MyClickListener {        fun onClick(position: Int)    }}
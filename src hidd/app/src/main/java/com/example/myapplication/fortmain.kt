package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class fortmain : AppCompatActivity(), fortadapter.MyClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: fortadapter
    private lateinit var itemDecorator: ItemDecorator
    private lateinit var imageView: ImageView // Declare imageView

    private var layoutManager: LinearLayoutManager? = null
    private var snapHelper: PagerSnapHelper? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fortmain)

        recyclerView = findViewById(R.id.recyclerView)
        val back = findViewById<ImageButton>(R.id.back)

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        snapHelper = PagerSnapHelper()
        snapHelper?.attachToRecyclerView(recyclerView)

        back.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }

        itemDecorator = ItemDecorator()
        recyclerView.addItemDecoration(itemDecorator)
        // -1 is the default value if the extra is not found


        val images = imageFort.imgfort
        val locations = locationfort.placefort
        val ratings = ratingfort.rating
        val info = fortinfo.info

        adapter = fortadapter(this, locations, images.toList(), ratings, info, this)
        recyclerView.adapter = adapter
    }

    override fun onClick(position: Int) {
        // Handle item click here
    }
}

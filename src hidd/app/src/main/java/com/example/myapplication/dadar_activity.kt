package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class dadar_activity : AppCompatActivity(), dadaradapter.MyClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: dadaradapter
    private lateinit var itemDecorator: ItemDecorator

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neral)

        recyclerView = findViewById(R.id.recyclerView)
        val back = findViewById<ImageButton>(R.id.back)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        val images = imgdadar.imgka
        val locations = locationdadr.places
        val ratings = ratingkalyan.rating

        itemDecorator = ItemDecorator()
        recyclerView.addItemDecoration(itemDecorator)

        back.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }

        adapter = dadaradapter(this, this, locations, images.toList(),ratings)
        recyclerView.adapter = adapter
    }

    override fun onClick(position: Int) {
        itemDecorator.setSelectedPosition(position)
        itemDecorator.refresh(recyclerView) // Call the refresh method
        startActivityForPosition(position)
    }

    private fun startActivityForPosition(position: Int) {
        when (position) {
            0 -> startActivity(Intent(this, AMBERNATH_aptinadi_activity::class.java))
            // Add more cases for other positions if needed
        }
    }
}

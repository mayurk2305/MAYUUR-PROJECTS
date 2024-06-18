package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ambernath_activity : AppCompatActivity(), Ambernathadapter.MyClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Ambernathadapter
    private lateinit var itemDecorator: ItemDecorator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ambernath)

        recyclerView = findViewById(R.id.recyclerView)
        val back = findViewById<ImageButton>(R.id.back)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        val images = imagess.imga
        val locations = locationambernath.places
        val ratings = ratingambernath.rating

        itemDecorator = ItemDecorator()
        recyclerView.addItemDecoration(itemDecorator)

        back.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }

        adapter = Ambernathadapter(this, this, locations, images.toList(),ratings)
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

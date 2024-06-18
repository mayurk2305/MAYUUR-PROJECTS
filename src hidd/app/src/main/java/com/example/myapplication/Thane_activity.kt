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

class Thane_activity : AppCompatActivity(), Thaneadapter.MyClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Thaneadapter
    private lateinit var itemDecorator: ItemDecorator
    private lateinit var imageView: ImageView // Declare imageView

    private var layoutManager: LinearLayoutManager? = null
    private var snapHelper: PagerSnapHelper? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thane)

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

        val images = imageT.imgt
        val locations = locationthane.placest
        val ratings = ratingthane.rating

        adapter = Thaneadapter(this, this, locations, images.toList(), ratings)
        recyclerView.adapter = adapter
    }

    override fun onClick(position: Int) {
        startActivityForPosition(position)
    }

    private fun startActivityForPosition(position: Int) {
        when (position) {
            0 -> startActivity(Intent(this, THANE_mansudalake_activity::class.java))
            1 -> startActivity(Intent(this, THANE_kopineshwartemple_activity::class.java))
            2 -> startActivity(Intent(this, THANE_mamachagaon_activity::class.java))
            // Add more cases for other positions if needed
        }
    }
}

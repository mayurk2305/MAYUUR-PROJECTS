package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HobbiesActivity : ComponentActivity(), StationAdapter.MyClickListener {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stn_main)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = layoutManager
        val images = imagstn.imgst
        val locations = supplies.station
        val adapter = StationAdapter(this, locations, images, this)  // Pass "this" as the click listener
        recyclerView.adapter = adapter
    }

    override fun onClick(position: Int) {
        when (position) {
            0 -> startActivity(Intent(this, khopoli_activity::class.java))
            1 -> startActivity(Intent(this, Thane_activity::class.java))
            2 -> startActivity(Intent(this, Ambernath_activity::class.java))
            3 -> startActivity(Intent(this, csmt_activity::class.java))
            4 -> startActivity(Intent(this, badlapur_activity::class.java))
            5 -> startActivity(Intent(this, kalyan_activity::class.java))
            6 -> startActivity(Intent(this, dadar_activity::class.java))
            7 -> startActivity(Intent(this, neral_activity::class.java))
            8 -> startActivity(Intent(this, ghatkopar_activity::class.java))
        }
    }
}

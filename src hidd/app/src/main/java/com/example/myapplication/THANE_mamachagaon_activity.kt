package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity

class THANE_mamachagaon_activity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thane_mamachagaon)
        val location = findViewById<ImageView>(R.id.ambernathloc)
        val share = findViewById<ImageView>(R.id.share)
        val cafe1 = findViewById<ImageView>(R.id.cafe_image1)
        val cafe2 = findViewById<ImageView>(R.id.cafe_image2)
        location.setOnClickListener {
            openLocationInMaps()
        }

        // Set OnClickListener for the share ImageView
        share.setOnClickListener {
            shareLiveLocationInMaps()
        }
        cafe1.setOnClickListener {
            startCafeActivity(21)
        }
        cafe2.setOnClickListener {
            startCafeActivity(22)
        }
    }

    private fun openLocationInMaps() {
        val latitude = "19.768825699885895" // Latitude of the location
        val longitude = "72.82325785343606" // Longitude of the location
        val label = "THANE" // Label for the location

        val uri = "geo:$latitude,$longitude?q=$latitude,$longitude($label)"
        val mapUri = Uri.parse(uri)
        val mapIntent = Intent(Intent.ACTION_VIEW, mapUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    private fun shareLiveLocationInMaps() {
        // You need to implement code to obtain the user's current location dynamically here
        // For demonstration purposes, let's assume the current location is hardcoded
        val currentLatitude = "19.768825699885895"
        val currentLongitude = "72.82325785343606"

        val label = "Current Location" // Label for the location

        val uri = "https://www.google.com/maps?q=$currentLatitude,$currentLongitude($label)"
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, uri)
        startActivity(Intent.createChooser(shareIntent, "Share live location via"))
    }
    private fun startCafeActivity(position: Int) {
        val intent = Intent(this, cafemain::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }
}

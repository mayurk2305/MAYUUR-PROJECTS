package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.ComponentActivity

class AMBERNATH_aptinadi_activity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ambernath_aptinadi)
        val location = findViewById<ImageView>(R.id.ambernathloc)
        val share = findViewById<ImageView>(R.id.share)
        val back = findViewById<ImageButton>(R.id.back2)
        val cafe1 = findViewById<ImageView>(R.id.cafe_image1)
        val cafe2 = findViewById<ImageView>(R.id.cafe_image2)
        // Set OnClickListener for the location ImageView
        back.setOnClickListener {
            val intent = Intent(this,Ambernath_activity::class.java)
            startActivity(intent)
        }
        location.setOnClickListener {
            openLocationInMaps()
        }
        cafe1.setOnClickListener {
            startCafeActivity(23)
        }
        cafe2.setOnClickListener {
            startCafeActivity(24)
        }

        // Set OnClickListener for the share ImageView
        share.setOnClickListener {
            shareLiveLocationInMaps()
        }
    }

    private fun openLocationInMaps() {
        val latitude = "19.218573" // Latitude of the location
        val longitude = "73.233935" // Longitude of the location
        val label = "Ambernath" // Label for the location

        val uri = "geo:$latitude,$longitude?q=$latitude,$longitude($label)"
        val mapUri = Uri.parse(uri)
        val mapIntent = Intent(Intent.ACTION_VIEW, mapUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    private fun shareLiveLocationInMaps() {
        // You need to implement code to obtain the user's current location dynamically here
        // For demonstration purposes, let's assume the current location is hardcoded
        val currentLatitude = "19.218573"
        val currentLongitude = "73.233935"

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

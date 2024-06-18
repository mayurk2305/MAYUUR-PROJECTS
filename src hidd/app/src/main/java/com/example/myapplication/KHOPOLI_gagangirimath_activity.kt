package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class KHOPOLI_gagangirimath_activity : ComponentActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_khopoli_gagangirimath)
        val location = findViewById<ImageView>(R.id.ambernathloc)
        val share = findViewById<ImageView>(R.id.share)
        val back = findViewById<ImageButton>(R.id.back)
        val cafe1 = findViewById<ImageView>(R.id.cafe_image1)
        val cafe2 = findViewById<ImageView>(R.id.cafe_image2)
        val img = findViewById<ImageView>(R.id.gagangiriview)
        val fav = findViewById<ImageView>(R.id.fav1)
        val title = findViewById<TextView>(R.id.name)

        // Set OnClickListener for the location ImageView
        back.setOnClickListener {
            val intent = Intent(this,khopoli_activity::class.java)
            startActivity(intent)
        }
        location.setOnClickListener {
            openLocationInMaps()
        }
        cafe1.setOnClickListener {
        startCafeActivity(15)
        }
        cafe2.setOnClickListener {
            startCafeActivity(16)
        }

        fav.setOnClickListener {
            // Assuming imagePath is the path of the image and title is the title of the image
            val imagePath = "path_to_your_image.jpg"
            val title = "Your Image Title"
            val result = Database.addImage(imagePath, title)
            if (result != -1L) {
                // Image saved successfully
                Toast.makeText(this, "Image saved to favorites", Toast.LENGTH_SHORT).show()
            } else {
                // Failed to save image
                Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show()
            }
        }

        // Set OnClickListener for the share ImageView
        share.setOnClickListener {
            shareLiveLocationInMaps()
        }
    }

    private fun openLocationInMaps() {
        val latitude = "18.786841988141106" // Latitude of the location
        val longitude = "73.35439867633677" // Longitude of the location
        val label = "khopoli" // Label for the location

        val uri = "geo:$latitude,$longitude?q=$latitude,$longitude($label)"
        val mapUri = Uri.parse(uri)
        val mapIntent = Intent(Intent.ACTION_VIEW, mapUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    private fun shareLiveLocationInMaps() {
        // You need to implement code to obtain the user's current location dynamically here
        // For demonstration purposes, let's assume the current location is hardcoded
        val currentLatitude = "18.786841988141106"
        val currentLongitude = "73.35439867633677"

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


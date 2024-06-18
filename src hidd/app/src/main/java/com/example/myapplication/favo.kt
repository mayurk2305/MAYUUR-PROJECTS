package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class FavoActivity : AppCompatActivity() {
    private lateinit var database: Database

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favo)

        database = Database(this)
        val db = database.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM ${Database.TABLE_IMAGES}", null)

        if (cursor.moveToFirst()) {
            val imagePath = cursor.getString(cursor.getColumnIndex(Database.COLUMN_IMAGE_PATH))
            val title = cursor.getString(cursor.getColumnIndex(Database.COLUMN_TITLE))

            // Load the image from the image path
            val imageResourceId = loadImageFromPath(imagePath)

            // Set the image and title to the views



        }

        cursor.close()
        db.close()
    }

    private fun loadImageFromPath(imagePath: String): Int {
        // Load the image from the image path and return its resource ID
        // You can use a library like Glide or Picasso to load the image
        // Here's an example using resources.getIdentifier:
        val resourceId = resources.getIdentifier(imagePath, "drawable", packageName)
        return resourceId
    }
}

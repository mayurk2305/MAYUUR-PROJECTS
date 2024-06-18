package com.example.limits

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity


class games: ComponentActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.games)
        val Ludo = findViewById<ImageButton>(R.id.ludooo)
        Ludo.setOnClickListener {
            val context2 = this
            val targetActivity = ludo::class.java
            val intent = Intent(context2,targetActivity)
            startActivity(intent)
        }

    }
}
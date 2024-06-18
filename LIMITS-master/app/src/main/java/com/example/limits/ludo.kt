package com.example.limits

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity

class ludo : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ludo)
        val amount = intent.getDoubleExtra("AMOUNT_EXTRA", 0.0)
        Toast.makeText(this, "Received amount: $amount", Toast.LENGTH_SHORT).show()
        val AMOUNT = amount

        val walletButton = findViewById<Button>(R.id.wallet)
        walletButton.setOnClickListener {
            // Create an intent to start the wallet activity
            val intent = Intent(this, wallet::class.java)

            // Pass the amount to the wallet activity
            intent.putExtra("AMOUNT_EXTRA", AMOUNT)

            // Start the wallet activity
            startActivity(intent)
        }
    }
}

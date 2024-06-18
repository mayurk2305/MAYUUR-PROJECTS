package com.example.limits

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class wallet : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wallet_xml)

        // Get the amount value from the intent
        val amount = intent.getDoubleExtra("AMOUNT_EXTRA",0.0 )

        Log.d("WalletActivity", "Received amount: $amount")
        Toast.makeText(this, "Received amount: $amount", Toast.LENGTH_SHORT).show()

        // Find the EditText by its ID
        val amountEditText: EditText = findViewById(R.id.amount)

        val button = findViewById<Button>(R.id.insertAmountButton)
        button.setOnClickListener {
            Toast.makeText(this, "PLEASE READ TERMS AND CONDITIONS FIRST", Toast.LENGTH_SHORT).show()
            val amountText: String = amountEditText.text.toString()

            // Debugging Toasts
            Toast.makeText(this, "LIMIT: $amount", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Entered Amount: $amountText", Toast.LENGTH_SHORT).show()

            try {
                val enteredAmount = amountText.toDouble()
                if (enteredAmount > amount) {
                    Toast.makeText(this, "YOU EXCEEDED YOUR LIMIT", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "AMOUNT DEPOSITED THANKS", Toast.LENGTH_SHORT).show()
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Invalid Amount Entered", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
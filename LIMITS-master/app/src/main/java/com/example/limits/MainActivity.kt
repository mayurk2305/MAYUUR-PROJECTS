package com.example.limits

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.limits.ui.theme.LIMITSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout);
        val Settings = findViewById<Button>(R.id.limitsettings);
        val control = findViewById<Button>(R.id.parentalnotifications);
        val progress = findViewById<Button>(R.id.checkprogress);
       Settings.setOnClickListener {
           val context2 = this
           val targetActivity = LimitSettings::class.java
           val intent = Intent(context2,targetActivity)
           startActivity(intent)
       }
      control.setOnClickListener {
          val context2 = this
          val targetActivity2 = parental_control::class.java
          val intent = Intent(context2,targetActivity2)
          startActivity(intent)
      }
      progress.setOnClickListener {
          val context2 = this
          val targetActivity3 = progressbaar::class.java
          val intent = Intent(context2,targetActivity3)
          startActivity(intent)
      }

    }
    }
package com.example.myapplication
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R.id

class MainActivity : ComponentActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var adapter: ImageSliderAdapter
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.imageSliderViewPager)
        adapter = ImageSliderAdapter(this)
        viewPager.adapter = adapter
        adapter.startAutoSlider(viewPager)

// get reference to button
        val fort = findViewById<ImageView>(R.id.fort)
        val cafe = findViewById<ImageView>(R.id.cafe)
        val kopineshwar = findViewById<ImageView>(R.id.kopineshwar1)
        val gagangiri = findViewById<ImageView>(R.id.gagangiri1)
        val kotachiwadi = findViewById<ImageView>(R.id.kotachiwadi1)
        val shivtemple = findViewById<ImageView>(R.id.shivtemple1)
        val cafe792 = findViewById<ImageView>(R.id.cafe1)
        val cupidcafe = findViewById<ImageView>(R.id.cupid1)
        val grandmaafe = findViewById<ImageView>(R.id.grandma1)
        val fav = findViewById<ImageView>(R.id.favorite1)
        val Recyclerview = findViewById(id.explore) as ImageView
        Recyclerview.setOnClickListener {
            val context2 = this
            val targetActivity2 = HobbiesActivity::class.java
            val intent = Intent(context2,targetActivity2)
            startActivity(intent)
        }
        kopineshwar.setOnClickListener {
            val context2 = this
            val targetActivity2 = THANE_kopineshwartemple_activity::class.java
            val intent = Intent(context2,targetActivity2)
            startActivity(intent)
        }
        gagangiri.setOnClickListener {
            val context2 = this
            val targetActivity2 = KHOPOLI_gagangirimath_activity::class.java
            val intent = Intent(context2,targetActivity2)
            startActivity(intent)
        }
        kotachiwadi.setOnClickListener {
            val context2 = this
            val targetActivity2 = CSMT_kotachiwadi_activity::class.java
            val intent = Intent(context2,targetActivity2)
            startActivity(intent)
        }
        shivtemple.setOnClickListener {
            val context2 = this
            val targetActivity2 = CSMT_khadaparsi_activity::class.java
            val intent = Intent(context2,targetActivity2)
            startActivity(intent)
        }
        fav.setOnClickListener {
            val intent = Intent(this,FavoActivity::class.java)
            startActivity(intent)
        }
        cafe792.setOnClickListener {
            startCafeActivity(13)

        }
        cupidcafe.setOnClickListener {
          startCafeActivity(0)

        }
        grandmaafe.setOnClickListener {
            startCafeActivity(14)

        }
        fort.setOnClickListener {
            val intent = Intent(this,fortmain::class.java)
            startActivity(intent)
        }
        cafe.setOnClickListener {
            val intent = Intent(this,cafemain::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        // Stop auto-sliding when the activity is destroyed
        adapter.stopAutoSlider()
        super.onDestroy()
    }

    private fun startCafeActivity(position: Int) {
        val intent = Intent(this, cafemain::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }
}


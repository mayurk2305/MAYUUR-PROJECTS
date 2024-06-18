package com.example.myapplication
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import java.util.Timer
import java.util.TimerTask

class ImageSliderAdapter(private val context: Context) : PagerAdapter() {

    private val images = arrayOf(
        R.drawable.apti_nadi,
        R.drawable.masunda_lake_talao_pali_min___copy_1,
        R.drawable.kotachi_wadi
    )
    private val texts = arrayOf(
        "APTI-RIVER",
        "MASUNDA-LAKE",
        "KOTACHI-WADI"
    )

    private val timer = Timer()
    private var currentPage = 0

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.imae_slider, container, false)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val textView = view.findViewById<TextView>(R.id.textView)
        imageView.setImageResource(images[position])
        textView.text = texts[position]
        container.addView(view)
        return view
    }

    override fun getCount(): Int = images.size

    override fun isViewFromObject(view: View, obj: Any): Boolean = view == obj

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    fun startAutoSlider(viewPager: ViewPager) {
        val handler = Handler(Looper.getMainLooper())
        val update = Runnable {
            if (currentPage == images.size) {
                currentPage = 0
            }
            viewPager.setCurrentItem(currentPage++, true)
        }

        timer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }, 500, 3000) // Change the delay and period (in milliseconds) as needed
    }

    fun stopAutoSlider() {
        timer.cancel()
    }
}

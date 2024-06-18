package com.example.myapplication

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecorator : RecyclerView.ItemDecoration() {
    private var selectedPosition = RecyclerView.NO_POSITION
    private val paint = Paint()

    init {
        paint.color = Color.BLUE
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 16f
    }

    fun setSelectedPosition(position: Int) {
        selectedPosition = position
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            if (parent.getChildAdapterPosition(child) == selectedPosition) {
                val params = child.layoutParams as RecyclerView.LayoutParams
                val left = child.left - params.leftMargin
                val right = child.right + params.rightMargin
                val top = child.top - params.topMargin
                val bottom = child.bottom + params.bottomMargin
                c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), paint)
                child.elevation = 17f // Set elevation for the selected item
            }
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
    }

    fun refresh(recyclerView: RecyclerView) {
        // Invalidate the RecyclerView's layout to trigger a re-draw
        recyclerView.invalidate()
    }
}

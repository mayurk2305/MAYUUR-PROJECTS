package com.example.myapplication
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView

class StartSnapHelper : LinearSnapHelper() {

    override fun findSnapView(layoutManager: RecyclerView.LayoutManager?): View? {
        if (layoutManager !is LinearLayoutManager) return null

        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
        val lastCompletelyVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition()

        return when {
            firstVisibleItemPosition == RecyclerView.NO_POSITION -> null
            lastCompletelyVisibleItemPosition == layoutManager.itemCount - 1 -> null
            else -> layoutManager.findViewByPosition(firstVisibleItemPosition)
        }
    }
}

package me.gomer.nsu_mmf.second.item_decoration

import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalPaddingItemDecoration(
    private val topPadding: Int,
    private val bottomPadding: Int,
    private val viewTypes: List<Int>,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildLayoutPosition(view)
        val viewType = parent.adapter?.getItemViewType(position)
        if (viewType !in viewTypes) return

        outRect.top = view.context.toPx(topPadding)
        outRect.bottom = view.context.toPx(bottomPadding)
    }
}
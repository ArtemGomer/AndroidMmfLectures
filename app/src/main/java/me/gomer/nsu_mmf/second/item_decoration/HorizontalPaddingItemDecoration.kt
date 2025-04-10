package me.gomer.nsu_mmf.second.item_decoration

import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

fun Context.toPx(dp: Int): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp.toFloat(),
        this.resources.displayMetrics
    ).toInt()
}

class HorizontalPaddingItemDecoration(
    private val rightPadding: Int,
    private val leftPadding: Int,
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

        outRect.left = view.context.toPx(leftPadding)
        outRect.right = view.context.toPx(rightPadding)
    }
}
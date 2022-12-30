package com.ruangaldo.ruanggame.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruangaldo.ruanggame.R
import com.ruangaldo.ruanggame.databinding.ItemListGameBinding
import com.ruangaldo.ruanggame.domain.model.GameUiItemModel
import com.ruangaldo.ruanggame.util.view.CoilUtil
import com.ruangaldo.ruanggame.util.view.DateFormat

/**
 * Written with joy and smile by Ruang Aldo on 30/12/22.
 * Github: https://github.com/reinaldoriant
 */

class GameListAdapter : RecyclerView.Adapter<GameListAdapter.ViewHolder>() {
    private val _items: MutableList<GameUiItemModel> = ArrayList()

    fun populatedItem(data: List<GameUiItemModel>) {
        _items.addAll(data)
        notifyItemInserted(_items.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_game, parent, false)
    )

    override fun getItemCount() = _items.size.coerceAtMost(10)

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemListGameBinding.bind(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            val item = _items[position]
            with(binding) {
                tvTitle.text = item.title
                item.image?.let {
                    CoilUtil.buildUrl(
                        itemView.context,
                        it,
                        ivImage,
                        "CENTER_CROP",
                        R.drawable.default_image_list
                    )
                }
                tvTimeTag.text = DateFormat.toFullMonthWithDay(item.release ?: "")
            }
        }
    }
}

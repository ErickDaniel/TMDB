package com.erick.juarez.tmdb.ui.mainView.viewHolder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.erick.juarez.tmdb.R
import com.erick.juarez.tmdb.databinding.ChipRowBinding
import com.erick.juarez.tmdb.domain.model.ChipDetail

class ChipViewHolder constructor(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val binding = ChipRowBinding.bind(view)

    fun render(chipDetail: ChipDetail, onItemClick: (chipTitle: ChipDetail, itemPosition: Int) -> Unit) =
        with(chipDetail){
            with(binding) {
                chipTitleTv.text = chipTitle
                chipTitleTv.setOnClickListener {
                    isSelected = !isSelected
                    onItemClick(chipDetail, layoutPosition)
                }
                if (!isSelected) {
                    chipTitleTv.background = ContextCompat.getDrawable(
                        binding.root.context, R.drawable.rounded_bg_unselected
                    )
                    chipTitleTv.setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))
                } else {
                    chipTitleTv.background = ContextCompat.getDrawable(
                        binding.root.context, R.drawable.rounded_bg_selected
                    )
                    chipTitleTv.setTextColor(ContextCompat.getColor(binding.root.context, R.color.black))
                }
            }
        }

}
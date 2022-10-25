package com.erick.juarez.tmdb.ui.mainView.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erick.juarez.tmdb.R
import com.erick.juarez.tmdb.databinding.ChipRowBinding
import com.erick.juarez.tmdb.domain.model.ChipDetail
import com.erick.juarez.tmdb.ui.mainView.viewHolder.ChipViewHolder

class ChipAdapter(
    private var chipList: List<ChipDetail>,
    private val onItemClick: (chipDetail: ChipDetail, itemPosition: Int) -> Unit
) : RecyclerView.Adapter<ChipViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ChipViewHolder(
            ChipRowBinding.bind(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.chip_row, parent, false)
            ).root
        )

    override fun onBindViewHolder(holder: ChipViewHolder, position: Int) =
        holder.render(chipList[position], onItemClick)

    override fun getItemCount() = chipList.size

}
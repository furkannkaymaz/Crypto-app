package com.cryptoApp.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cryptoApp.base.BaseAdapter
import com.cryptoApp.data.remote.model.CoinModelResult
import com.cryptoApp.databinding.ItemCoinListBinding
import com.cryptoApp.utils.extensions.loadImage

class CoinAdapter(private val itemClick: ((CoinModelResult) -> Unit)) : BaseAdapter<CoinModelResult, CoinAdapter.ViewHolder>() {

    override fun createView(
        context: Context,
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(ItemCoinListBinding.inflate(inflater, parent, false))
    }

    class ViewHolder(val binding: ItemCoinListBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun bindView(holder: ViewHolder, position: Int, item: CoinModelResult) {
            item.image?.let { images -> holder.binding.ivCoin.loadImage(images) }
            holder.binding.tvCoinName.text = item.name

        holder.binding.container.setOnClickListener {
            itemClick(item)
        }
    }
}


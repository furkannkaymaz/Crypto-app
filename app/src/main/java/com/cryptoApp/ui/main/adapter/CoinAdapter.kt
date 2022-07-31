package com.cryptoApp.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cryptoApp.base.BaseAdapter
import com.cryptoApp.data.remote.model.CoinModel
import com.cryptoApp.data.remote.model.CoinModelResult
import com.cryptoApp.databinding.ItemCoinListBinding
import com.cryptoApp.utils.extensions.loadImage

class CoinAdapter(private val itemClick: ((CoinModel) -> Unit)) : BaseAdapter<CoinModel, CoinAdapter.ViewHolder>() {

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


    override fun bindView(holder: ViewHolder, position: Int, item: CoinModel) {
        holder.binding.ivCoin.setOnClickListener {
            item[position].image?.let { images -> holder.binding.ivCoin.loadImage(images) }
            itemClick(item)
        }
    }

}


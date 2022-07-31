package com.cryptoApp.ui.main.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cryptoApp.base.BaseFragment
import com.cryptoApp.data.remote.model.Coin
import com.cryptoApp.data.remote.model.CoinModelResult
import com.cryptoApp.databinding.FragmentMainBinding
import com.cryptoApp.ui.main.adapter.CoinAdapter
import com.cryptoApp.ui.main.view_model.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainFragmentViewModel>() {

    override val viewModel by viewModels<MainFragmentViewModel>()
    private lateinit var adapter: CoinAdapter
    private var searchItem: Coin? = null

    override fun onCreateFinished() {

        binding?.rvCoin?.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

    //    binding?.rvCoin?.adapter = adapter
    }

    override fun observerData() {
        super.observerData()
        getData()
        viewModel.getCoinList.observe(viewLifecycleOwner, {

       //     searchItem = it
            Log.d("datamessage",it.toString())

    //        setRecycleViewData(it)

        })
    }

    private fun getData() {

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getCoinList()
        }
    }

    private fun setRecycleViewData(list: Coin) {

        adapter.set(arrayListOf(list))
        adapter.notifyDataSetChanged()

    }

    override fun layoutResource(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }


}
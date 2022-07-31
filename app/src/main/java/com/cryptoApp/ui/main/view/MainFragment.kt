package com.cryptoApp.ui.main.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cryptoApp.R
import com.cryptoApp.base.BaseFragment
import com.cryptoApp.data.remote.model.CoinModel
import com.cryptoApp.data.remote.model.CoinModelResult
import com.cryptoApp.databinding.FragmentMainBinding
import com.cryptoApp.ui.detail.view.DetailFragmentArgs
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
    private var coinData : ArrayList<CoinModelResult> = arrayListOf()

    override fun onCreateFinished() {

        sendAdapterData()
        configureUiItems()
        getData()
        getSearchItem()

    }

    private fun getData() {

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getCoinList()
        }
    }

    override fun observerData() {

        viewModel.getCoinList.observe(viewLifecycleOwner, {

            it.forEach {
                coinData.add(it)
            }

            setRecycleViewData(coinData)

        })

        viewModel.error.observe(viewLifecycleOwner, {

            Toast.makeText(requireContext(), R.string.error,Toast.LENGTH_SHORT).show()
        })

        viewModel.isLoading.observe(viewLifecycleOwner, {

            if (it == false){
                binding?.progress?.visibility = View.GONE
            }
        })
    }

    private fun getSearchItem() {

        binding?.svSearch?.getEditText()?.addTextChangedListener{ text ->

            CoroutineScope(Dispatchers.IO).launch {
                context?.let { viewModel.getFilterText(text.toString(), coinData) }
            }

            viewModel.filterText.observe(viewLifecycleOwner, {
                setRecycleViewData(it as ArrayList<CoinModelResult>)
            })
        }

    }

    private fun setRecycleViewData(list: ArrayList<CoinModelResult>) {

        adapter.set(list)
        adapter.notifyDataSetChanged()

    }

    private fun configureUiItems() {
        binding?.rvCoin?.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding?.rvCoin?.adapter = adapter
    }

    override fun layoutResource(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }

    private fun sendAdapterData() {
        adapter = CoinAdapter {
            it.id?.let { it1 -> goDetailPage(it1) }
        }
    }

    private fun goDetailPage(id: String) {
        val navController = Navigation.findNavController(requireActivity(), R.id.main)
        navController.navigate(
            R.id.action_fragmentMain_to_detailFragment,
            DetailFragmentArgs(id).toBundle()
        )
    }

}
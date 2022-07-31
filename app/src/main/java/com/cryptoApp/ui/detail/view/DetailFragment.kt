package com.cryptoApp.ui.detail.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.cryptoApp.R
import com.cryptoApp.base.BaseFragment
import com.cryptoApp.databinding.FragmentDetailBinding
import com.cryptoApp.ui.detail.view_model.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding,DetailViewModel>() {

    override val viewModel by viewModels<DetailViewModel>()

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateFinished() {
      getData()
    }

    private fun getData() {

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getCoinDetail(args.id)
        }
    }

    override fun observerData() {

        viewModel.getCoinList.observe(viewLifecycleOwner, {

            binding?.tvCoinName?.text = it.name
            binding?.tvCurrentPrice?.text = it.developerScore.toString()
        })

        viewModel.error.observe(viewLifecycleOwner, {

            Toast.makeText(requireContext(), R.string.error, Toast.LENGTH_SHORT).show()
        })

        viewModel.isLoading.observe(viewLifecycleOwner, {

            if (it == false){
                binding?.progress?.visibility = View.GONE
            }
        })
    }

    override fun layoutResource(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater,container,false)
    }

}
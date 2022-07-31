package com.cryptoApp.ui.detail.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.cryptoApp.R
import com.cryptoApp.base.BaseFragment
import com.cryptoApp.databinding.FragmentDetailBinding
import com.cryptoApp.ui.detail.view_model.DetailViewModel
import com.cryptoApp.utils.extensions.loadImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import android.os.CountDownTimer
import android.util.Log
import com.cryptoApp.utils.extensions.toast


@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    override val viewModel by viewModels<DetailViewModel>()
    private lateinit var navController: NavController
    private val args: DetailFragmentArgs by navArgs()
    var timer: CountDownTimer? = null

    override fun onCreateFinished() {
        navController = Navigation.findNavController(requireActivity(), R.id.main)
        getData()
    }

    private fun setTimer(time: Long){
        timer =  object : CountDownTimer(time * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding?.etTimer?.setText("${millisUntilFinished / 1000}")
                binding?.etTimer?.isEnabled = false

            }

            override fun onFinish() {
                getData()
                binding?.etTimer?.isEnabled = true
            }
        }.start()
    }

    override fun clickListeners() {
        super.clickListeners()
        binding?.ivBack?.setOnClickListener {
            navController.navigate(
                R.id.action_detailFragment_to_fragmentMain,
            )
        }

        binding?.ivRefresh?.setOnClickListener {
            getData()
        }

        binding?.btnRefreshTimer?.setOnClickListener {
            setTimer(binding?.etTimer?.text.toString().toLong())
        }
    }

    private fun getData() {

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getCoinDetail(args.id)
        }
    }

    override fun observerData() {

        viewModel.getCoinList.observe(viewLifecycleOwner, {

            binding?.apply {
                if (!it.name.isNullOrEmpty()) {
                    tvCoinName.text = it.name
                } else {
                    tvCoinName.visibility = View.GONE
                }
                it.image?.large?.let { it1 -> ivCoin.loadImage(it1) }

                if (it.market_data?.price_change_percentage_24h != null) {
                    tv24Percentage.text =
                        "24 saat değişim yüzdesi ${it.market_data.price_change_percentage_24h}"
                } else {
                    tv24Percentage.visibility = View.GONE
                }

                it.market_data?.current_price?.forEach {
                    if (it.key == "try") {
                        tvCurrentPrice.text = "${it.value} TRY"
                    }
                }

                if (!it.description?.en.isNullOrEmpty()) {
                    tvDesc.text = it.description?.en
                } else {
                    tvDesc.visibility = View.GONE
                }

                if (!it.hashing_algorithm.isNullOrEmpty()) {
                    tvHashingAlgoritma.text = it.hashing_algorithm
                } else {
                    tvHashingAlgoritma.visibility = View.GONE
                }


                contentTop.setText(it.name.toString(), requireActivity())
            }

        })

        viewModel.error.observe(viewLifecycleOwner, {

            Toast.makeText(requireContext(), R.string.error, Toast.LENGTH_SHORT).show()
        })

        viewModel.isLoading.observe(viewLifecycleOwner, {

            if (it == false) {
                binding?.progress?.visibility = View.GONE
            }
        })
    }

    override fun layoutResource(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        timer = null
    }

}
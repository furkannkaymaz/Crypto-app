package com.cryptoApp.ui.detail.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cryptoApp.data.remote.model.CoinDetailModel
import com.cryptoApp.data.remote.model.CoinModel
import com.cryptoApp.data.remote.model.CoinModelResult
import com.cryptoApp.data.remote.repository.DetailRepository
import com.cryptoApp.data.remote.repository.MainRepository
import com.cryptoApp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val detailRepository: DetailRepository): ViewModel() {

    private val _getCoinList = MutableLiveData<CoinDetailModel>()
    val getCoinList: LiveData<CoinDetailModel>
        get() = _getCoinList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _filterText = MutableLiveData<List<CoinModelResult>>()
    val filterText: LiveData<List<CoinModelResult>>
        get() = _filterText

    fun getCoinDetail(id : String) {

        viewModelScope.launch {
            _isLoading.value = true
            when (val response = detailRepository.getDetailData(id)) {
                is Resource.Success -> {
                    _getCoinList.postValue(response.data)
                    _isLoading.value = false

                }
                is Resource.Error -> {
                    _error.postValue(response.message)
                    _isLoading.value = false
                }
            }
        }
    }


}
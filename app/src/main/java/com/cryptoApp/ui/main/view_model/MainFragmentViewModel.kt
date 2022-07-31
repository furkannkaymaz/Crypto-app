package com.cryptoApp.ui.main.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cryptoApp.data.remote.model.CoinModel
import com.cryptoApp.data.remote.model.CoinModelResult
import com.cryptoApp.data.remote.repository.MainRepository
import com.cryptoApp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel  @Inject constructor(private val mainRepository: MainRepository): ViewModel() {

    private val _getCoinList = MutableLiveData<CoinModel>()
    val getCoinList: LiveData<CoinModel>
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

    fun getCoinList() {

        viewModelScope.launch {
           _isLoading.value = true
            when (val response = mainRepository.getData()) {
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

    fun getFilterText(keyword: String, searchItem: List<CoinModelResult>?) {

        viewModelScope.launch {

            val filter = searchItem?.filter { it.atlDate?.contains(keyword, true) == true }
            _filterText.value = filter

        }

    }

}
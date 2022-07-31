package com.cryptoApp.data.remote.repository

import com.cryptoApp.data.remote.dto.ApiServices
import com.cryptoApp.base.BaseRepository
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService : ApiServices,
) : BaseRepository() {
    suspend fun getData(
    ) = safeApiRequest {
        apiService.getCoins()
    }
}
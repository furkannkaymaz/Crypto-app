package com.cryptoApp.data.remote.repository

import com.cryptoApp.base.BaseRepository
import com.cryptoApp.data.remote.dto.ApiServices
import javax.inject.Inject

class DetailRepository @Inject constructor(
    private val apiService : ApiServices,
) : BaseRepository() {

    suspend fun getDetailData(id : String,
    ) = safeApiRequest {
        apiService.getDetailData(id)
    }

}
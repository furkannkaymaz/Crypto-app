package com.cryptoApp.data.remote.dto


import com.cryptoApp.data.remote.model.CoinDetailModel
import com.cryptoApp.data.remote.model.CoinModel
import com.cryptoApp.data.remote.model.CoinModelResult
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {

    @GET("coins/markets?vs_currency=usd&order=market_cap_desc&per_page=200&page=1&sparkline=false")
    suspend fun getCoins(): CoinModel

    @GET("coins/{id}")
    suspend fun getDetailData(
        @Path("id") id : String
    ): CoinDetailModel

}
package com.cryptoApp.data.remote.dto

import com.cryptoApp.data.remote.model.Coin
import com.cryptoApp.data.remote.model.CoinModelResult
import retrofit2.http.GET

interface ApiServices {

    @GET("coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false")
    suspend fun getCoins(
    ): Coin

}
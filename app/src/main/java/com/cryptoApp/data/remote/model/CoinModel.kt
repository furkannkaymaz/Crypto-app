package com.cryptoApp.data.remote.model

class CoinModel: ArrayList<CoinModelResult>()

data class CoinModelResult(
    val id: String? = null,
    val symbol: String? = null,
    val name: String? = null,
    val image: String? = null,
    val currentPrice: Double? = null,
    val marketCap: Long? = null,
    val marketCapRank: Long? = null,
    val fullyDilutedValuation: Long? = null,
    val totalVolume: Double? = null,
    val high24H: Double? = null,
    val low24H: Double? = null,
    val priceChange24H: Double? = null,
    val priceChangePercentage24H: Double? = null,
    val marketCapChange24H: Double? = null,
    val marketCapChangePercentage24H: Double? = null,
    val circulatingSupply: Double? = null,
    val totalSupply: Double? = null,
    val maxSupply: Double? = null,
    val ath: Double? = null,
    val athChangePercentage: Double? = null,
    val athDate: String? = null,
    val atl: Double? = null,
    val atlChangePercentage: Double? = null,
    val atlDate: String? = null,
    val roi: Roi? = null,
    val lastUpdated: String? = null
)

data class Roi(
    val times: Double? = null,
    val currency: Currency? = null,
    val percentage: Double? = null
)

enum class Currency {
    Btc,
    Eth,
    Usd
}

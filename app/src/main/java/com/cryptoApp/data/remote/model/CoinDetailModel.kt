package com.cryptoApp.data.remote.model

data class CoinDetailModel (
    val id: String? = null,
    val symbol: String? = null,
    val name: String? = null,
    val assetPlatformID: Any? = null,
    val platforms: Platforms? = null,
    val blockTimeInMinutes: Long? = null,
    val hashing_algorithm: String? = null,
    val categories: List<String>? = null,
    val publicNotice: Any? = null,
    val additionalNotices: List<Any?>? = null,
    val localization: Tion? = null,
    val description: Tion? = null,
    val links: Links? = null,
    val image: Image? = null,
    val countryOrigin: String? = null,
    val genesisDate: String? = null,
    val sentimentVotesUpPercentage: Double? = null,
    val sentimentVotesDownPercentage: Double? = null,
    val marketCapRank: Long? = null,
    val coingeckoRank: Long? = null,
    val coingeckoScore: Double? = null,
    val developerScore: Double? = null,
    val communityScore: Double? = null,
    val liquidityScore: Double? = null,
    val publicInterestScore: Double? = null,
    val market_data: MarketData? = null,
    val communityData: CommunityData? = null,
    val developerData: DeveloperData? = null,
    val publicInterestStats: PublicInterestStats? = null,
    val statusUpdates: List<Any?>? = null,
    val lastUpdated: String? = null,
    val tickers: List<Ticker>? = null
)

data class CommunityData (
    val facebookLikes: Any? = null,
    val twitterFollowers: Long? = null,
    val redditAveragePosts48H: Long? = null,
    val redditAverageComments48H: Double? = null,
    val redditSubscribers: Long? = null,
    val redditAccountsActive48H: Long? = null,
    val telegramChannelUserCount: Any? = null
)

data class Tion (
    val en: String? = null,
    val de: String? = null,
    val es: String? = null,
    val fr: String? = null,
    val it: String? = null,
    val pl: String? = null,
    val ro: String? = null,
    val hu: String? = null,
    val nl: String? = null,
    val pt: String? = null,
    val sv: String? = null,
    val vi: String? = null,
    val tr: String? = null,
    val ru: String? = null,
    val ja: String? = null,
    val zh: String? = null,
    val zhTw: String? = null,
    val ko: String? = null,
    val ar: String? = null,
    val th: String? = null,
    val id: String? = null,
    val cs: String? = null,
    val da: String? = null,
    val el: String? = null,
    val hi: String? = null,
    val no: String? = null,
    val sk: String? = null,
    val uk: String? = null,
    val he: String? = null,
    val fi: String? = null,
    val bg: String? = null,
    val hr: String? = null,
    val lt: String? = null,
    val sl: String? = null
)

data class DeveloperData (
    val forks: Long? = null,
    val stars: Long? = null,
    val subscribers: Long? = null,
    val totalIssues: Long? = null,
    val closedIssues: Long? = null,
    val pullRequestsMerged: Long? = null,
    val pullRequestContributors: Long? = null,
    val codeAdditionsDeletions4_Weeks: CodeAdditionsDeletions4_Weeks? = null,
    val commitCount4_Weeks: Long? = null,
    val last4_WeeksCommitActivitySeries: List<Any?>? = null
)

data class CodeAdditionsDeletions4_Weeks (
    val additions: Long? = null,
    val deletions: Long? = null
)

enum class ID {
    Binancecoin,
    Bitcoin,
    Ethereum,
    EthereumClassic,
    FinexboxToken,
    Solana,
    WrappedBitcoin
}

data class Image (
    val thumb: String? = null,
    val small: String? = null,
    val large: String? = null
)

data class Links (
    val homepage: List<String>? = null,
    val blockchainSite: List<String>? = null,
    val officialForumURL: List<String>? = null,
    val chatURL: List<String>? = null,
    val announcementURL: List<String>? = null,
    val twitterScreenName: ID? = null,
    val facebookUsername: String? = null,
    val bitcointalkThreadIdentifier: Any? = null,
    val telegramChannelIdentifier: String? = null,
    val subredditURL: String? = null,
    val reposURL: ReposURL? = null
)

data class ReposURL (
    val github: List<String>? = null,
    val bitbucket: List<Any?>? = null
)

data class MarketData (
    val current_price: Map<String, Double>? = null,
    val totalValueLocked: Any? = null,
    val mcapToTvlRatio: Any? = null,
    val fdvToTvlRatio: Any? = null,
    val roi: Any? = null,
    val ath: Map<String, Double>? = null,
    val athChangePercentage: Map<String, Double>? = null,
    val athDate: Map<String, String>? = null,
    val atl: Map<String, Double>? = null,
    val atlChangePercentage: Map<String, Double>? = null,
    val atlDate: Map<String, String>? = null,
    val marketCap: Map<String, Double>? = null,
    val marketCapRank: Long? = null,
    val fullyDilutedValuation: Map<String, Double>? = null,
    val totalVolume: Map<String, Double>? = null,
    val high24H: Map<String, Double>? = null,
    val low24H: Map<String, Double>? = null,
    val price_change_24h: Double? = null,
    val price_change_percentage_24h: Double? = null,
    val priceChangePercentage7D: Double? = null,
    val priceChangePercentage14D: Double? = null,
    val priceChangePercentage30D: Double? = null,
    val priceChangePercentage60D: Double? = null,
    val priceChangePercentage200D: Double? = null,
    val priceChangePercentage1Y: Double? = null,
    val marketCapChange24H: Double? = null,
    val marketCapChangePercentage24H: Double? = null,
    val priceChange24HInCurrency: Map<String, Double>? = null,
    val priceChangePercentage1HInCurrency: Map<String, Double>? = null,
    val priceChangePercentage24HInCurrency: Map<String, Double>? = null,
    val priceChangePercentage7DInCurrency: Map<String, Double>? = null,
    val priceChangePercentage14DInCurrency: Map<String, Double>? = null,
    val priceChangePercentage30DInCurrency: Map<String, Double>? = null,
    val priceChangePercentage60DInCurrency: Map<String, Double>? = null,
    val priceChangePercentage200DInCurrency: Map<String, Double>? = null,
    val priceChangePercentage1YInCurrency: Map<String, Double>? = null,
    val marketCapChange24HInCurrency: Map<String, Double>? = null,
    val marketCapChangePercentage24HInCurrency: Map<String, Double>? = null,
    val totalSupply: Long? = null,
    val maxSupply: Long? = null,
    val circulatingSupply: Long? = null,
    val lastUpdated: String? = null
)

data class Platforms (
    val empty: String? = null
)

data class PublicInterestStats (
    val alexaRank: Long? = null,
    val bingMatches: Any? = null
)

data class Ticker (
    val base: Base? = null,
    val target: Target? = null,
    val market: Market? = null,
    val last: Double? = null,
    val volume: Double? = null,
    val convertedLast: Map<String, Double>? = null,
    val convertedVolume: Map<String, Double>? = null,
    val trustScore: TrustScore? = null,
    val bidAskSpreadPercentage: Double? = null,
    val timestamp: String? = null,
    val lastTradedAt: String? = null,
    val lastFetchAt: String? = null,
    val isAnomaly: Boolean? = null,
    val isStale: Boolean? = null,
    val tradeURL: String? = null,
    val tokenInfoURL: Any? = null,
    val coinID: ID? = null,
    val targetCoinID: TargetCoinID? = null
)

enum class Base {
    Bnb,
    Btc,
    Etc,
    Eth,
    Fnb,
    Sol,
    Wbtc,
    Xbt
}

data class Market (
    val name: String? = null,
    val identifier: String? = null,
    val hasTradingIncentive: Boolean? = null
)

enum class Target {
    Btc,
    Busd,
    Eur,
    Gbp,
    Jpy,
    Usd,
    Usdc,
    Usdt
}

enum class TargetCoinID {
    BinanceUsd,
    Bitcoin,
    Tether,
    UsdCoin
}

enum class TrustScore {
    Green
}

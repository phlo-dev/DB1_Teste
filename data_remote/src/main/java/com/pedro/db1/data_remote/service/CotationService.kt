package com.pedro.db1.data_remote.service

import com.pedro.db1.data_remote.MARKET_PRICE_ENDPOINT
import com.pedro.db1.data_remote.MarketPriceResponse
import retrofit2.http.GET

interface CotationService{
    @GET(MARKET_PRICE_ENDPOINT)
    suspend fun getMarketPriceCharts(): MarketPriceResponse
}
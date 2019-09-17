package com.pedro.db1.data_remote.service

import com.pedro.db1.data_remote.MARKET_PRICE_ENDPOINT
import com.pedro.db1.data_remote.TIME_SPAN_QUERY
import com.pedro.db1.data_remote.model.MarketPriceResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CotationService{
    @GET(MARKET_PRICE_ENDPOINT)
    suspend fun getMarketPriceCharts(@Query(TIME_SPAN_QUERY) params: String): MarketPriceResponse
}
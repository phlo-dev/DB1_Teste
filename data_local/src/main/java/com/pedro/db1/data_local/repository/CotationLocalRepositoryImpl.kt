package com.pedro.db1.data_local.repository

import com.pedro.db1.data.local.CotationLocalRepository
import com.pedro.db1.data_local.dao.CotationFilterDao
import com.pedro.db1.data_local.mapper.fromDomain
import com.pedro.db1.data_local.mapper.toDomain
import com.pedro.db1.domain.model.CotationValue

class CotationLocalRepositoryImpl(
    private val database: CotationFilterDao
) : CotationLocalRepository {
    override fun saveCotationsValues(cotationList: List<CotationValue>, timeSpan: String) =
        database.insertAllCotationsValues(*cotationList.fromDomain(timeSpan).toTypedArray())

    override fun getCotationValues(timeSpan: String) =
        database.getCotationList(timeSpan).toDomain()
}
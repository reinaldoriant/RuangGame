package com.ruangaldo.ruanggame.util.network

import com.ruangaldo.ruanggame.util.wrapper.DataResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import timber.log.Timber

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

abstract class NetworkBoundResource<ResultType, RequestType> {
    private var result: Flow<DataResource<ResultType>> = flow {
        val dbSource = loadFromDB().first()
        if (shouldFetch(dbSource)) {
            when (val apiResponse = createCall()) {
                is DataResource.Success -> {
                    apiResponse.let {
                        Timber.d("Data load $it")
                        it.payload?.let { it1 -> saveCallResult(it1) }
                    }
                    emitAll(loadFromDB().map {
                        DataResource.Success(
                            it
                        )
                    })
                }
                is DataResource.Error -> {
                    onFetchFailed()
                    emit(
                        DataResource.Error(
                            apiResponse.exception
                        )
                    )
                    emitAll(loadFromDB().map { DataResource.Success(it) })
                }
            }
        } else {
            emitAll(loadFromDB().map {
                DataResource.Success(
                    it
                )
            })
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract suspend fun loadFromDB(): Flow<ResultType>

    protected abstract suspend fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): DataResource<RequestType>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<DataResource<ResultType>> = result
}

package com.ruangaldo.ruanggame.data.repository

import com.ruangaldo.ruanggame.util.exception.ApiErrorException
import com.ruangaldo.ruanggame.util.exception.NoInternetConnectionException
import com.ruangaldo.ruanggame.util.exception.UnexpectedErrorException
import com.ruangaldo.ruanggame.util.wrapper.DataResource
import java.io.IOException
import retrofit2.HttpException

/**
 * Written with joy and smile by Ruang Aldo on 30/12/22.
 * Github: https://github.com/reinaldoriant
 */

abstract class BaseRepository {
    suspend fun <T> safeNetworkCall(apiCall: suspend () -> T): DataResource<T> {
        return try {
            DataResource.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> DataResource.Error(NoInternetConnectionException())
                is HttpException -> {
                    DataResource.Error(ApiErrorException(throwable.response()?.errorBody().toString(), throwable.code()))
                }
                else -> {
                    DataResource.Error(UnexpectedErrorException())
                }
            }
        }
    }

    suspend fun <T> proceed(coroutine: suspend () -> T): DataResource<T> {
        return try {
            DataResource.Success(coroutine.invoke())
        } catch (exception: Exception) {
            DataResource.Error(exception)
        }
    }
}

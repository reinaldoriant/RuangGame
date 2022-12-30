package com.ruangaldo.ruanggame.util.wrapper

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

sealed class ViewResource<T>(
    val payload: T? = null,
    val message: String? = null,
    val exception: Exception? = null
) {
    class Success<T>(data: T) : ViewResource<T>(data)
    class Error<T>(exception: Exception?, data: T? = null, msg: String? = null) :
        ViewResource<T>(data, exception = exception, message = msg)
    class Loading<T>(data: T? = null) : ViewResource<T>(data)
}

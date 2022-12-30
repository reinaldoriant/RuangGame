package com.ruangaldo.ruanggame.util.extension

import com.ruangaldo.ruanggame.util.wrapper.DataResource
import com.ruangaldo.ruanggame.util.wrapper.ViewResource

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

suspend fun <T> DataResource<T>.suspendSubscribe(
    doOnSuccess: suspend (resource: DataResource<T>) -> Unit,
    doOnError: suspend (resource: DataResource<T>) -> Unit,
) {
    when (this) {
        is DataResource.Success -> doOnSuccess.invoke(this)
        is DataResource.Error -> doOnError.invoke(this)
    }
}

fun <T> ViewResource<T>.subscribe(
    doOnSuccess: ((resource: ViewResource<T>) -> Unit)? = null,
    doOnError: ((resource: ViewResource<T>) -> Unit)? = null,
    doOnLoading: ((resource: ViewResource<T>) -> Unit)? = null,
) {
    when (this) {
        is ViewResource.Success -> doOnSuccess?.invoke(this)
        is ViewResource.Error -> doOnError?.invoke(this)
        is ViewResource.Loading -> doOnLoading?.invoke(this)
    }
}

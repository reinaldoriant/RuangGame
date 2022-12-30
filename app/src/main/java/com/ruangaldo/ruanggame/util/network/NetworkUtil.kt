package com.ruangaldo.ruanggame.util.network

import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.RetentionManager.Period.ONE_HOUR
import com.ruangaldo.ruanggame.ApplicationController

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

object NetworkUtil {
    val chuckerCollector = ChuckerCollector(
        context = ApplicationController.appContext,
        showNotification = true,
        retentionPeriod = ONE_HOUR,
    )
}

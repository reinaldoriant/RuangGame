package com.ruangaldo.ruanggame.util.view

import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Written with joy and smile by Ruang Aldo on 30/12/22.
 * Github: https://github.com/reinaldoriant
 */

object DateFormat {
    private val locale = Locale("in", "ID")
    private val dateOnly = SimpleDateFormat("yyyy-MM-dd", locale)
    private val localeDateTime = SimpleDateFormat("EEEE, d MMMM y", locale)

    fun toFullMonthWithDay(time: String): String {
        return try {
            val date = dateOnly.parse(time)
            localeDateTime.format(date!!)
        } catch (ex: Exception) {
            ""
        }
    }
}

package com.ruangaldo.ruanggame.util.exception

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

class FieldErrorException(val errorFields: List<Pair<Int, Int>>) : Exception()

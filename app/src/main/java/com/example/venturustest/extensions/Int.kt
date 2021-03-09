package com.example.venturustest.extensions

import java.text.DecimalFormat

fun Int.formatter(): String {
    return DecimalFormat("##,###.##", ).format(this)
}
package com.quadriyanney.kudimoney_test

import java.text.SimpleDateFormat
import java.util.*

fun Long.toDay(): String =
    SimpleDateFormat("YYYY MMMM, dd", Locale.getDefault()).format(Date(this))

fun Long.toTime(): String =
    SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date(this))
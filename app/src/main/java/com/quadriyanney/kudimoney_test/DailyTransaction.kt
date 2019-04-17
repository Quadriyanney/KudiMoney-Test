package com.quadriyanney.kudimoney_test

import com.saber.stickyheader.stickyData.StickyMainData

data class DailyTransaction (
    val dayOfMonth: Long,
    val transactions: List<Transaction>
)

data class Transaction (
    val label: String,
    val type: Int,
    val amount: Double,
    val timeOfDay: Long
) : StickyMainData
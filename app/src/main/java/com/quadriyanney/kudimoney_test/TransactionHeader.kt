package com.quadriyanney.kudimoney_test

import com.saber.stickyheader.stickyData.HeaderData

class TransactionHeader(var dayInTimestamp: Long) : HeaderData {

    override fun getHeaderType(): Int = 1

    override fun getHeaderLayout(): Int = R.layout.item_transaction_header
}
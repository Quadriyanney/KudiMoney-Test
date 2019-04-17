package com.quadriyanney.kudimoney_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.saber.stickyheader.stickyView.StickHeaderRecyclerView
import kotlinx.android.synthetic.main.item_transaction.view.*
import kotlinx.android.synthetic.main.item_transaction_header.view.*

class TransactionsAdapter : StickHeaderRecyclerView<Transaction, TransactionHeader>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> HeaderViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_transaction_header, parent, false))
            else -> ItemViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_transaction, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> holder.bind(position)
            is HeaderViewHolder -> holder.bind(position)
        }
    }

    override fun bindHeaderData(header: View?, headerPosition: Int) {
        val transactionHeader = getHeaderDataInPosition(headerPosition)
        header?.findViewById<TextView>(R.id.tvDay)?.text = transactionHeader.dayInTimestamp.toDay()
    }

    inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {
            val transaction = getDataInPosition(position)
            itemView.tvLabel.text = transaction.label
            itemView.tvTime.text  = transaction.timeOfDay.toTime()

            when (transaction.type) {
                0 -> {
                    val amount = "+ $${transaction.amount}"
                    itemView.tvAmount.text = amount
                    itemView.tvAmount.setTextColor(ContextCompat.getColor(itemView.context, R.color.colorPrimary))
                }
                else -> {
                    val amount = "- $${transaction.amount}"
                    itemView.tvAmount.text = amount
                    itemView.tvAmount.setTextColor(ContextCompat.getColor(itemView.context, R.color.colorAccent))
                }
            }
        }
    }

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {
            val transactionHeader = getHeaderDataInPosition(position)
            itemView.tvDay.text = transactionHeader.dayInTimestamp.toDay()
        }
    }
}
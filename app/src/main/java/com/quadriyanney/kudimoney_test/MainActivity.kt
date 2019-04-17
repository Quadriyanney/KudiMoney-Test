package com.quadriyanney.kudimoney_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.EntryXComparator
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val scrollList = arrayListOf<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entries = ArrayList<Entry>()
        val transactionsAdapter = TransactionsAdapter()
        rvTransactions.adapter = transactionsAdapter
        rvTransactions.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        DummyData.generateTransactions().forEach { dailyTransaction ->
            transactionsAdapter.setHeaderAndData(
                dailyTransaction.transactions, TransactionHeader(dailyTransaction.dayOfMonth))
            tabLayout.addTab(tabLayout.newTab().setText(dailyTransaction.dayOfMonth.toDay()))

            scrollList.add(dailyTransaction.dayOfMonth.toDay())
            scrollList.addAll(dailyTransaction.transactions)

            dailyTransaction.transactions.forEach { transaction ->
                entries.add(Entry(transaction.timeOfDay.toFloat(), transaction.amount.toFloat()))
            }
        }

        Collections.sort(entries, EntryXComparator())

        val dataSet = LineDataSet(entries, "")
        dataSet.setDrawCircles(false)
        dataSet.setDrawValues(false)
        dataSet.color = ContextCompat.getColor(this, R.color.colorAccent)

        val lineData = LineData(dataSet)

        chart.data = lineData
        chart.axisLeft.setDrawLabels(false)
        chart.axisRight.setDrawLabels(false)
        chart.xAxis.setDrawLabels(false)
        chart.xAxis.setDrawAxisLine(false)
        chart.axisLeft.setDrawGridLines(false)
        chart.axisRight.setDrawGridLines(false)
        chart.xAxis.setDrawGridLines(false)
        chart.legend.isEnabled = false
        chart.axisRight.setDrawAxisLine(false)
        chart.axisLeft.setDrawAxisLine(false)

        val desc = Description()
        desc.text =""
        chart.description = desc

        chart.invalidate()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(selectedTab: TabLayout.Tab?) {
                rvTransactions.scrollToPosition(scrollList.indexOf(selectedTab?.text.toString()) + 1)
            }
        })

    }
}

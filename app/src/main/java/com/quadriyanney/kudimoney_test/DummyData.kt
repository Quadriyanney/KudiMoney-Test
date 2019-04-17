package com.quadriyanney.kudimoney_test

class DummyData {

    companion object {
        fun generateTransactions() : List<DailyTransaction> {
            return arrayListOf(
                DailyTransaction(1555518842000, arrayListOf(
                    Transaction("Kudimoney", 1, 2.0, 1555515242000),
                    Transaction("Random", 1, 15.0, 1555511642000),
                    Transaction("Random", 1, 20.0, 1555504442000),
                    Transaction("Kudimoney", 0, 12.0, 1555497242000)
                )),
                DailyTransaction(1550399642000, arrayListOf(
                    Transaction("Friend", 0, 10.0, 1555515242000),
                    Transaction("Kudimoney", 0, 10.0, 1555511642000),
                    Transaction("Family", 1, 25.0, 1555504442000),
                    Transaction("Kudimoney", 0, 5.0, 1555497242000)
                )),
                DailyTransaction(1547721242000, arrayListOf(
                    Transaction("Random", 1, 2.0, 1555515242000),
                    Transaction("Kudimoney", 0, 2.0, 1555511642000),
                    Transaction("Friend", 1, 2.0, 1555504442000),
                    Transaction("Family", 1, 14.0, 1555497242000)
                )),
                DailyTransaction(1542450842000, arrayListOf(
                    Transaction("Family", 1, 23.0, 1555515242000),
                    Transaction("Family", 0, 5.0, 1555511642000),
                    Transaction("Random", 0, 3.0, 1555504442000),
                    Transaction("Friend", 0, 7.0, 1555497242000)
                )),
                DailyTransaction(1537180442000, arrayListOf(
                    Transaction("Friend", 0, 16.0, 1555515242000),
                    Transaction("Kudimoney", 0, 12.0, 1555511642000),
                    Transaction("Random", 1, 21.0, 1555504442000),
                    Transaction("Family", 1, 14.0, 1555497242000)
                )),
                DailyTransaction(1529231642000, arrayListOf(
                    Transaction("Random", 1, 5.0, 1555515242000),
                    Transaction("Kudimoney", 0, 3.0, 1555511642000),
                    Transaction("Friend", 1, 10.0, 1555504442000),
                    Transaction("Family", 1, 13.0, 1555497242000)
                )),
                DailyTransaction(1525194577000, arrayListOf(
                    Transaction("Kudimoney", 1, 20.0, 1555515242000),
                    Transaction("Random", 1, 2.0, 1555511642000),
                    Transaction("Random", 1, 10.0, 1555504442000),
                    Transaction("Kudimoney", 0, 18.0, 1555497242000)
                ))
            )
        }
    }
}
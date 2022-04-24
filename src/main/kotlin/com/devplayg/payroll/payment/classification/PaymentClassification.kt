package com.devplayg.asd.payroll.payment.classification

import java.time.LocalDate

interface PaymentClassification {
    fun calculatePay(): Long
}


data class SalariedClassification(
    val salary: Long
) : PaymentClassification {

    override fun calculatePay(): Long {
        return 0
    }
}


data class HourlyClassification(
    val hourRate: Double
) : PaymentClassification {
    val timeCardList = mutableListOf<TimeCard>()

    fun addTimeCard(timeCard: TimeCard) {
        timeCardList.add(timeCard)
    }

    override fun calculatePay(): Long {
        return 0
    }
}

data class TimeCard(
    val date: LocalDate,
    val hours: Int
)

data class CommissionedClassification(
    val salary: Long,
    val commissionRate: Double
) : PaymentClassification {
    override fun calculatePay(): Long {
        return 0
    }
}
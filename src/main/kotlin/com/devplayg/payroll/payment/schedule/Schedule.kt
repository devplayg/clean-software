package com.devplayg.asd.payroll.payment.schedule

interface Schedule {
    fun isPayday(): Boolean

}

class MonthlySchedule : Schedule {
    override fun isPayday(): Boolean {
        return true
    }
}

class WeeklySchedule : Schedule {
    override fun isPayday(): Boolean {
        return true
    }
}

class BiweeklySchedule : Schedule {
    override fun isPayday(): Boolean {
        return true
    } }
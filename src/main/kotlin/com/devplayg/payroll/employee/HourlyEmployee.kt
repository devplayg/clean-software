package com.devplayg.asd.payroll.employee

import com.devplayg.asd.payroll.affiliation.Affiliation
import com.devplayg.asd.payroll.affiliation.NoAffiliation
import com.devplayg.asd.payroll.payment.classification.HourlyClassification
import com.devplayg.asd.payroll.payment.method.HoldMethod
import com.devplayg.asd.payroll.payment.method.PaymentMethod
import com.devplayg.asd.payroll.payment.schedule.WeeklySchedule
import java.time.LocalDate

data class HourlyEmployee(
    override val id: Long,
    override val name: String,
    val hourRate: Double,
): Employee {
    override val paymentClassification = HourlyClassification(hourRate)
    override val schedule = WeeklySchedule()
    override val paymentMethod: PaymentMethod = HoldMethod()
    override var affiliation: Affiliation = NoAffiliation()

}

package com.devplayg.asd.payroll.employee

import com.devplayg.asd.payroll.affiliation.Affiliation
import com.devplayg.asd.payroll.affiliation.NoAffiliation
import com.devplayg.asd.payroll.payment.classification.SalariedClassification
import com.devplayg.asd.payroll.payment.method.HoldMethod
import com.devplayg.asd.payroll.payment.method.PaymentMethod
import com.devplayg.asd.payroll.payment.schedule.MonthlySchedule

data class SalariedEmployee(
    override val id: Long,
    override val name: String,
    val salary: Long,
): Employee {
    override val paymentClassification = SalariedClassification(salary)
    override val schedule = MonthlySchedule()
    override val paymentMethod: PaymentMethod = HoldMethod()
    override var affiliation: Affiliation = NoAffiliation()

}
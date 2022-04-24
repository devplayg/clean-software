package com.devplayg.asd.payroll.employee

import com.devplayg.asd.payroll.affiliation.Affiliation
import com.devplayg.asd.payroll.affiliation.NoAffiliation
import com.devplayg.asd.payroll.payment.classification.CommissionedClassification
import com.devplayg.asd.payroll.payment.method.HoldMethod
import com.devplayg.asd.payroll.payment.method.PaymentMethod
import com.devplayg.asd.payroll.payment.schedule.BiweeklySchedule
import java.time.LocalDate

data class CommissionedEmployee(
    override val id: Long,
    override val name: String,
    val salary: Long,
    val commissionRate: Double
) : Employee {
    override val paymentClassification = CommissionedClassification(salary, commissionRate)
    override val schedule = BiweeklySchedule()
    override val paymentMethod: PaymentMethod = HoldMethod()
    override var affiliation: Affiliation = NoAffiliation()

    val salesReceiptList = mutableListOf<SalesReceipt>()

    fun addSalesReceipt(salesReceipt: SalesReceipt) {
        salesReceiptList.add(salesReceipt)
    }
}

data class SalesReceipt(
    val date: LocalDate,
    val amount: Long
)


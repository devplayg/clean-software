package com.devplayg.asd.payroll.employee

import com.devplayg.asd.payroll.affiliation.Affiliation
import com.devplayg.asd.payroll.payment.classification.PaymentClassification
import com.devplayg.asd.payroll.payment.method.PaymentMethod
import com.devplayg.asd.payroll.payment.schedule.Schedule

interface Employee {
    val id: Long
    val name: String

    val paymentClassification: PaymentClassification
    val schedule: Schedule
    val paymentMethod: PaymentMethod
    var affiliation: Affiliation
}

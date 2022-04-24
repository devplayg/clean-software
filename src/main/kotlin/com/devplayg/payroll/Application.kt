package com.devplayg.asd.payroll

import com.devplayg.asd.payroll.affiliation.UnionAffiliation
import com.devplayg.asd.payroll.transaction.*
import java.time.LocalDate

val database = PayrollDatabase()

fun main(args: Array<String>) {
    println(333)

    // 1
    val addHourlyEmployeeTransaction = AddHourlyEmployeeTransaction(1, "won", 15.25)
    addHourlyEmployeeTransaction.execute()

    // 2
    val addSalesReceiptTransaction = AddSalariedEmployeeTransaction(2, "won", 100000)
    addSalesReceiptTransaction.execute()

    val timeCardTransaction = TimeCardTransaction(1, LocalDate.now(), 2)
    timeCardTransaction.execute()

    // 3
    val addCommissionedEmployeeTransaction = AddCommissionedEmployeeTransaction(3, "won", 40000, 0.03)
    addCommissionedEmployeeTransaction.execute()


    val txSalesReceiptTransaction = SalesReceiptTransaction(3, LocalDate.now(), 50000)
    txSalesReceiptTransaction.execute()

    database.list()
}
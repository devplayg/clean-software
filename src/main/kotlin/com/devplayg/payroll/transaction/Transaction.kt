package com.devplayg.asd.payroll.transaction

import com.devplayg.asd.payroll.database
import com.devplayg.asd.payroll.employee.CommissionedEmployee
import com.devplayg.asd.payroll.employee.HourlyEmployee
import com.devplayg.asd.payroll.employee.SalariedEmployee
import com.devplayg.asd.payroll.employee.SalesReceipt
import com.devplayg.asd.payroll.payment.classification.TimeCard
import java.time.LocalDate

interface Transaction {
    fun execute()
}

data class AddSalariedEmployeeTransaction(
    val id: Long,
    val name: String,
    val salary: Long
) : Transaction {
    override fun execute() {
        val employee = SalariedEmployee(id, name, salary)
        database.add(employee)
    }
}

data class AddHourlyEmployeeTransaction(
    val id: Long,
    val name: String,
    val hourRate: Double
) : Transaction {
    override fun execute() {
        val employee = HourlyEmployee(id, name, hourRate)
        database.add(employee)
    }
}

data class AddCommissionedEmployeeTransaction(
    val id: Long,
    val name: String,
    val salary: Long,
    val commissionRate: Double
) : Transaction {
    override fun execute() {
        val employee = CommissionedEmployee(id, name, salary, commissionRate)
        database.add(employee)
    }
}

data class DeleteEmployeeTransaction(
    val id: Long
) : Transaction {
    override fun execute() {
        database.del(id)
    }
}

data class TimeCardTransaction(
    val empId: Long,
    val date: LocalDate,
    val hours: Int
) : Transaction {
    override fun execute() {
        val employee = database.findById(empId)!!
        if (employee !is HourlyEmployee) {
            return
        }
        employee.paymentClassification.addTimeCard(TimeCard(date, hours))
    }
}

data class SalesReceiptTransaction(
    val empId: Long,
    val date: LocalDate,
    val amount: Long
) : Transaction {
    override fun execute() {
        val employee = database.findById(empId)!!
        if (employee !is CommissionedEmployee) {
            return
        }
        employee.addSalesReceipt(SalesReceipt(date, amount))
    }
}

data class PaydayTransaction(
    val date: LocalDate
) : Transaction {
    override fun execute() {

    }
}

data class ServiceChargeTransaction(
    val empId: Long,
    val date: LocalDate,
    val serviceCharge: Double
) : Transaction {
    override fun execute() {
    }
}
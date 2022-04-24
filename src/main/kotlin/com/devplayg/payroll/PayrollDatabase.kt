package com.devplayg.asd.payroll

import com.devplayg.asd.payroll.employee.Employee
import com.devplayg.asd.payroll.employee.HourlyEmployee

data class PayrollDatabase(
    val m: MutableMap<Long, Employee> = mutableMapOf()
) {
    fun findById(id: Long) = m[id]

    fun add(e: Employee) {
        m[e.id] = e
    }

    fun del(id: Long) {
        m.remove(id)
    }

    fun list() {
        m.forEach {(id, e) ->
            println("===================")
            println("id=$id")
            println("name=${e.name}")
            println("type=${e}")
            if (e is HourlyEmployee) {
                println(e.paymentClassification.timeCardList)
            }


        }
    }
}
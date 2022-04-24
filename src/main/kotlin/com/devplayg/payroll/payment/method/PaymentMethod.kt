package com.devplayg.asd.payroll.payment.method

interface PaymentMethod

class HoldMethod : PaymentMethod

data class DirectMethod(
    val bank: Int,
    val account: String
) : PaymentMethod

data class MailMethod(
    val email: String
) : PaymentMethod
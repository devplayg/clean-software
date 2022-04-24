package com.devplayg.asd.payroll.affiliation

interface Affiliation

class NoAffiliation : Affiliation {
}

data class UnionAffiliation(
    private val serviceCharge: Double
) : Affiliation


data class ServiceCharge(
    val charge: Long
)
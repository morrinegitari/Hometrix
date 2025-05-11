package com.morrine.hometrix.model

// File: Property.kt


data class Property(
    val id: String,
    val name: String,
    val location: String,
    val price: Double,
    val isAvailable: Boolean
)


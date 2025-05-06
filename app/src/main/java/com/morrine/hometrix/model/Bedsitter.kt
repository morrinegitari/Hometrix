package com.morrine.hometrix.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bedsitter")
data class Bedsitter(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val phone: String,
    val location: String,
    val bedroom: String,
    val bathroom: String,
    val price: Double,
    val imagePath: String
)

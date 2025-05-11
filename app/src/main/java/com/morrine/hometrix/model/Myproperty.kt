package com.morrine.hometrix.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mypropertys")
data class Myproperty(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val price: Double,
    val phone: String,
    val imagePath: String
)



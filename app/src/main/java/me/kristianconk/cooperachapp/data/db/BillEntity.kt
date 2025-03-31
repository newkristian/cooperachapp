package me.kristianconk.cooperachapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bills")
data class BillEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: String,
    val amount: Double,
    val people: Int,
    val tipType: String,
    val tipAmount: Double,
    val total: Double
)
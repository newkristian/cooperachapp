package me.kristianconk.cooperachapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.kristianconk.cooperachapp.calculator.calcTotal
import me.kristianconk.cooperachapp.domain.model.SplitedBill
import me.kristianconk.cooperachapp.domain.model.TipType
import java.time.LocalDateTime

@Entity(tableName = "bills")
data class BillEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: String,
    val amount: Double,
    val people: Int,
    val tipType: String,
    val tipAmount: Int,
    val total: Double
) {
    fun toSplitedBill(): SplitedBill {
        return SplitedBill(
            date = converters.fromTimestamp(date) ?: LocalDateTime.now(),
            amount = amount,
            people = people,
            tipType = TipType.valueOf(tipType, tipAmount)
        )
    }

    companion object {
        val converters = Converters()
        fun fromSplitedBill(splitedBill: SplitedBill): BillEntity {
            return BillEntity(
                date = converters.dateToTimestamp(splitedBill.date) ?: "",
                amount = splitedBill.amount,
                people = splitedBill.people,
                tipType = splitedBill.tipType.toString(),
                tipAmount = splitedBill.tipType.quantity,
                total = calcTotal(splitedBill.amount, splitedBill.people, splitedBill.tipType)
            )
        }
    }
}


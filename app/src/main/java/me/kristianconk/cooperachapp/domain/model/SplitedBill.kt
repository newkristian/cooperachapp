package me.kristianconk.cooperachapp.domain.model

import java.time.LocalDateTime

data class SplitedBill(
    val date: LocalDateTime,
    val amount: Double,
    val people: Int,
    val tipType: TipType
)

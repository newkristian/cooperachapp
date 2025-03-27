package me.kristianconk.cooperachapp.presentation.utils

import java.util.Locale

object FormatUtils {
    fun formatShareMessage(
        amount: Double,
        tip: Double,
        people: Int,
        totalPerPerson: Double
    ): String {
        return String.format(
            locale = Locale.getDefault(),
            format = "El total de la cuenta fue de $%.2f, más propina de $%.2f, dividiendolo entre %d personas, nos toca de $%.2f",
            amount,
            tip,
            people,
            totalPerPerson
        )

    }
}
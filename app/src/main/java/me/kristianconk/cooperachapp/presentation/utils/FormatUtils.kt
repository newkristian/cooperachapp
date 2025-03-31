package me.kristianconk.cooperachapp.presentation.utils

import java.util.Locale

object FormatUtils {

    val currencyFormat = java.text.NumberFormat.getCurrencyInstance(Locale("es", "MX"))

    fun formatShareMessage(
        amount: Double,
        tip: Double,
        people: Int,
        totalPerPerson: Double
    ): String {
        return String.format(
            locale = Locale.getDefault(),
            format = "El total de la cuenta fue de %s, más propina de %s, dividido entre %d personas, nos toca de %s",
            formatDoubleToMexicanCurrency(amount),
            formatDoubleToMexicanCurrency(tip),
            people,
            formatDoubleToMexicanCurrency(totalPerPerson)
        )

    }

    fun formatDoubleToMexicanCurrency(amount: Double): String {
        currencyFormat.maximumFractionDigits = 2
        currencyFormat.minimumFractionDigits = 2
        return currencyFormat.format(amount)

    }
}
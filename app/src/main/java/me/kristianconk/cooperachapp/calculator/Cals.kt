package me.kristianconk.cooperachapp.calculator

fun calcTotal(amount: Double, people: Int, tipType: TipType): Double {
    val tip = calcTip(amount, tipType)
    return calcTotal(amount, people, tip)
}

fun calcTotal(amount: Double, people: Int, tip: Double): Double {
    return (amount + tip)/people.toDouble()
}

fun calcTip(amount: Double, tipType:TipType): Double {
    when(tipType) {
        is TipType.NONE -> return 0.0
        is TipType.PERCENT -> return (amount * tipType.quantity.toDouble()) / 100.0
        is TipType.FIXED -> return tipType.quantity.toDouble()
        else -> return 0.0
    }
}

sealed class TipType(val quantity: Int) {
    data object NONE : TipType(0)
    class PERCENT(quantity: Int): TipType(quantity)
    class FIXED(quantity: Int): TipType(quantity)
}
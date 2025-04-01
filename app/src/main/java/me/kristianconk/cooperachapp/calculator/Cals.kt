package me.kristianconk.cooperachapp.calculator

import me.kristianconk.cooperachapp.domain.model.SplitedBill
import me.kristianconk.cooperachapp.domain.model.TipType

fun calcTotal(bill: SplitedBill): Double {
    val tip = calcTip(bill)
    return calcTotal(bill.amount, bill.people, tip)
}

fun calcTotal(amount: Double, people: Int, tipType: TipType): Double {
    val tip = calcTip(amount, tipType)
    return calcTotal(amount, people, tip)
}

fun calcTotal(amount: Double, people: Int, tip: Double): Double {
    return (amount + tip)/people.toDouble()
}

fun calcTip(bill: SplitedBill): Double {
    return calcTip(bill.amount, bill.tipType)
}

fun calcTip(amount: Double, tipType:TipType): Double {
    when(tipType) {
        is TipType.NONE -> return 0.0
        is TipType.PERCENT -> return (amount * tipType.quantity.toDouble()) / 100.0
        is TipType.FIXED -> return tipType.quantity.toDouble()
        else -> return 0.0
    }
}
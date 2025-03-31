package me.kristianconk.cooperachapp.domain.model

sealed class TipType(val quantity: Int) {
    data object NONE : TipType(0)
    class PERCENT(quantity: Int) : TipType(quantity)
    class FIXED(quantity: Int) : TipType(quantity)

    companion object {
        fun valueOf(type: String, quantity: Int): TipType {
            return when (type) {
                "NONE" -> NONE
                "PERCENT" -> PERCENT(quantity)
                "FIXED" -> FIXED(quantity)
                else -> NONE
            }
        }
    }
}

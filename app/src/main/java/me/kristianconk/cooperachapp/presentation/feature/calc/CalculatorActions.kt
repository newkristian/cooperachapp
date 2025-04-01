package me.kristianconk.cooperachapp.presentation.feature.calc

import me.kristianconk.cooperachapp.domain.model.SplitedBill

data class CalculatorActions(
    val onShareClick: (String) -> Unit = {},
    val onSaveClick: (SplitedBill) -> Unit = {},
    val onHistoryClick: () -> Unit = {}
)

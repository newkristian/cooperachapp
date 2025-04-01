package me.kristianconk.cooperachapp.presentation.feature.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.kristianconk.cooperachapp.domain.model.SplitedBill
import me.kristianconk.cooperachapp.domain.repository.BillRepository

class HistoryViewModel(
    private val repository: BillRepository
): ViewModel() {

    private val _bills = MutableStateFlow<List<SplitedBill>>(emptyList())
    val bills = _bills.asStateFlow()

    fun getBills() = viewModelScope.launch {
        repository.getAllBillsStream().collect {
            _bills.value = it
        }
    }

    fun insertBill(bill: SplitedBill) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.insertBill(bill)
        }
    }
}
package me.kristianconk.cooperachapp.domain.repository

import kotlinx.coroutines.flow.Flow
import me.kristianconk.cooperachapp.domain.model.SplitedBill

interface BillRepository {

    suspend fun getAllBillsStream(): Flow<List<SplitedBill>>

    suspend fun getBillByIdStream(id: Int): Flow<SplitedBill?>

    suspend fun insertBill(bill: SplitedBill)
}
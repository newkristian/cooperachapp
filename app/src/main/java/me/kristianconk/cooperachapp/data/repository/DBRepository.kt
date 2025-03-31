package me.kristianconk.cooperachapp.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.kristianconk.cooperachapp.data.db.BillDao
import me.kristianconk.cooperachapp.data.db.BillEntity
import me.kristianconk.cooperachapp.domain.model.SplitedBill
import me.kristianconk.cooperachapp.domain.repository.BillRepository

class DBRepository(
    private val billDao: BillDao
): BillRepository {

    override suspend fun getAllBillsStream(): Flow<List<SplitedBill>> {
        return billDao.getAllBills().map { list -> list.map { it.toSplitedBill() } }
    }

    override suspend fun getBillByIdStream(id: Int): Flow<SplitedBill?> {
        return billDao.getItem(id).map { it.toSplitedBill() }
    }

    override suspend fun insertBill(bill: SplitedBill) {
        billDao.insert(BillEntity.fromSplitedBill(bill))
    }

}
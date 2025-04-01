package me.kristianconk.cooperachapp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BillDao {

    @Query("SELECT * FROM bills")
    fun getAllBills(): Flow<List<BillEntity>>

    @Query("SELECT * from bills WHERE id = :id")
    fun getItem(id: Int): Flow<BillEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(bill: BillEntity)

    @Delete
    fun delete(bill: BillEntity)

    @Query("DELETE FROM bills")
    fun deleteAll()
}
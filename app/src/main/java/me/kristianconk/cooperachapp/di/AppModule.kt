package me.kristianconk.cooperachapp.di

import me.kristianconk.cooperachapp.data.db.BillDao
import me.kristianconk.cooperachapp.data.db.BillDatabase
import me.kristianconk.cooperachapp.data.repository.DBRepository
import me.kristianconk.cooperachapp.domain.repository.BillRepository
import me.kristianconk.cooperachapp.presentation.feature.history.HistoryViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // === data ===
    // daos
    single<BillDao> { BillDatabase.getInstance(get()).billDao() }
    // api

    // data source
    // repo
    single<BillRepository> { DBRepository(get()) }
    // === domain ===

    // === presentation ===
    viewModel { HistoryViewModel(get()) }
}
package me.kristianconk.cooperachapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import me.kristianconk.cooperachapp.data.db.BillDatabase
import me.kristianconk.cooperachapp.data.repository.DBRepository
import me.kristianconk.cooperachapp.presentation.feature.history.HistoryViewModel
import me.kristianconk.cooperachapp.presentation.navigation.HomeNavigation
import me.kristianconk.cooperachapp.ui.theme.CooperachAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val historyViewModel = HistoryViewModel(DBRepository(BillDatabase.getInstance(this).billDao()))
            CooperachAppTheme {
                HomeNavigation(historyViewModel = historyViewModel, activity = this@MainActivity)
            }
        }
    }
}

package me.kristianconk.cooperachapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import me.kristianconk.cooperachapp.presentation.feature.history.HistoryViewModel
import me.kristianconk.cooperachapp.presentation.navigation.HomeNavigation
import me.kristianconk.cooperachapp.ui.theme.CooperachAppTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val historyViewModel = koinViewModel<HistoryViewModel>()
            CooperachAppTheme {
                HomeNavigation(historyViewModel = historyViewModel, activity = this@MainActivity)
            }
        }
    }
}

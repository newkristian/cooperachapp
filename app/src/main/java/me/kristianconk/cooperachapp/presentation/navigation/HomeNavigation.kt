package me.kristianconk.cooperachapp.presentation.navigation

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.kristianconk.cooperachapp.presentation.feature.calc.CalculatorActions
import me.kristianconk.cooperachapp.presentation.feature.calc.CalculatorScreen
import me.kristianconk.cooperachapp.presentation.feature.history.HistoryViewModel
import me.kristianconk.cooperachapp.presentation.feature.splash.SplashScreen

@Composable
fun HomeNavigation(historyViewModel: HistoryViewModel, activity: ComponentActivity) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navToHome = {
                navController.navigate("home") {
                    /*popUpTo("splash") {
                        inclusive = true
                    }*/
                }
            })
        }
        composable("home") {
            CalculatorScreen(actions = CalculatorActions(
                onShareClick = { message ->
                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, message)
                        type = "text/plain"
                    }
                    val shareIntent = Intent.createChooser(sendIntent, null)
                    activity.startActivity(shareIntent)
                },
                onSaveClick = { historyViewModel.insertBill(it) },
                onHistoryClick = { navController.navigate("history") }
            ))
        }
    }
}
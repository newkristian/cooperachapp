package me.kristianconk.cooperachapp.presentation.navigation

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.kristianconk.cooperachapp.presentation.CalculatorScreen
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
            CalculatorScreen {  }
        }
    }
}
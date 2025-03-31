package me.kristianconk.cooperachapp.presentation.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import me.kristianconk.cooperachapp.R
import me.kristianconk.cooperachapp.ui.theme.CooperachAppTheme

@Composable
fun SplashScreen(navToHome: () -> Unit) {
    LaunchedEffect(key1 = Unit) {
        delay(2000L)
        navToHome()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.split_bill), contentDescription = "Logo",
            modifier = Modifier.size(200.dp))
    }
}

@Composable
@Preview(showSystemUi = true)
fun SplashScreenPreview() {
    CooperachAppTheme {
        SplashScreen({})

    }
}
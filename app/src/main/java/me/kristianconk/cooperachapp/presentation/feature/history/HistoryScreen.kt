package me.kristianconk.cooperachapp.presentation.feature.history

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.kristianconk.cooperachapp.domain.model.SplitedBill
import me.kristianconk.cooperachapp.domain.model.TipType
import me.kristianconk.cooperachapp.ui.theme.CooperachAppTheme
import java.time.LocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    items: List<SplitedBill> = emptyList(),
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Historial", color = MaterialTheme.colorScheme.onPrimary) },
                modifier = Modifier,
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            tint = MaterialTheme.colorScheme.onPrimary,
                            contentDescription = "volver"
                        )
                    }
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),
            )
        }) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(items.size) {
                HistoryItem(item = items[it])
            }
        }
    }
}

@Composable
fun HistoryItem(item: SplitedBill, modifier: Modifier = Modifier) {
    Text(text = "${item.amount}")
}

@Composable
@Preview
fun HistoryScreenPreview() {
    CooperachAppTheme {
        HistoryScreen(
            listOf(
                SplitedBill(LocalDateTime.now(), 100.0, 2, TipType.FIXED(10)),
            )
        )
    }
}

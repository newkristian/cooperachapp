package me.kristianconk.cooperachapp.presentation.feature.history

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.kristianconk.cooperachapp.domain.model.SplitedBill
import me.kristianconk.cooperachapp.ui.theme.CooperachAppTheme

@Composable
fun HistoryScreen(
    items: List<SplitedBill> = emptyList(),
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
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

        )
    }
}

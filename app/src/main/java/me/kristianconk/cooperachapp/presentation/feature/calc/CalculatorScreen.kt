package me.kristianconk.cooperachapp.presentation.feature.calc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.kristianconk.cooperachapp.R
import me.kristianconk.cooperachapp.calculator.calcTotal
import me.kristianconk.cooperachapp.domain.model.SplitedBill
import me.kristianconk.cooperachapp.domain.model.TipType
import me.kristianconk.cooperachapp.presentation.utils.FormatUtils
import me.kristianconk.cooperachapp.ui.theme.CooperachAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen(actions: CalculatorActions) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Co-operach App",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),
                actions = {
                    IconButton(onClick = actions.onHistoryClick) {
                        Icon(
                            imageVector = Icons.Default.History,
                            tint = MaterialTheme.colorScheme.onPrimary,
                            contentDescription = "Historial"
                        )

                    }
                }
            )
        }
    ) { paddingValues ->
        var totalText by remember {
            mutableStateOf("")
        }
        var peopleText by remember {
            mutableStateOf("")
        }
        var tipText by remember {
            mutableStateOf("")
        }
        var selectedNoTip by remember { mutableStateOf(false) }
        var selectedPercentageTip by remember { mutableStateOf(false) }
        var selectedQuantityTip by remember { mutableStateOf(true) }
        val tipType by remember {
            derivedStateOf {
                val tipInt = tipText.toIntOrNull() ?: 0
                when {
                    selectedNoTip -> TipType.NONE
                    selectedPercentageTip -> TipType.PERCENT(tipInt)
                    selectedQuantityTip -> TipType.FIXED(tipInt)
                    else -> TipType.NONE
                }
            }
        }
        val totalFinal = remember {
            derivedStateOf {
                val totalDouble = totalText.toDoubleOrNull() ?: 0.0
                val peopleInt = peopleText.toIntOrNull() ?: 1
                calcTotal(totalDouble, peopleInt, tipType)
            }
        }
        var lastFinal by remember { mutableDoubleStateOf(totalFinal.value) }
        var saveEnabled by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            OutlinedTextField(
                value = totalText,
                onValueChange = { newVal ->
                    val filtered = newVal.filter { char -> char.isDigit() || char == '.' }
                    totalText = filtered
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = stringResource(id = R.string.calculator_input_amount)
                    )
                },
                leadingIcon = {
                    Text(text = "$")
                },
                trailingIcon = {
                    if (totalText.isNotEmpty()) {
                        IconButton(onClick = { totalText = "" }) {
                            Icon(Icons.Filled.Clear, contentDescription = "Clear")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = peopleText,
                onValueChange = { newVal ->
                    val filtered = newVal.filter { char -> char.isDigit() }
                    peopleText = filtered
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.calculator_input_people))
                },
                leadingIcon = {
                    Icon(Icons.Filled.Person, contentDescription = "people")
                },
                trailingIcon = {
                    if (peopleText.isNotEmpty()) {
                        IconButton(onClick = { peopleText = "" }) {
                            Icon(Icons.Filled.Clear, contentDescription = "Clear")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FilterChip(
                    selected = selectedNoTip,
                    onClick = {
                        selectedNoTip = true; selectedPercentageTip = false; selectedQuantityTip =
                        false
                    },
                    label = { Text(text = stringResource(id = R.string.calculator_input_no_tip)) })
                FilterChip(
                    selected = selectedPercentageTip,
                    onClick = {
                        selectedNoTip = false; selectedPercentageTip = true; selectedQuantityTip =
                        false
                    },
                    label = { Text(text = stringResource(id = R.string.calculator_input_percentage_tip)) })
                FilterChip(
                    selected = selectedQuantityTip,
                    onClick = {
                        selectedNoTip = false; selectedPercentageTip = false; selectedQuantityTip =
                        true
                    },
                    label = { Text(text = stringResource(id = R.string.calculator_input_tip)) })
            }
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = tipText,
                onValueChange = { newVal ->
                    val filtered = newVal.filter { char -> char.isDigit() }
                    tipText = filtered
                },
                label = { Text(text = stringResource(id = R.string.calculator_input_tip_amount)) },
                modifier = Modifier
                    .fillMaxWidth(),
                enabled = selectedQuantityTip || selectedPercentageTip,
                trailingIcon = {
                    if (tipText.isNotEmpty()) {
                        IconButton(onClick = { tipText = "" }) {
                            Icon(Icons.Filled.Clear, contentDescription = "Clear")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

                )
            Spacer(modifier = Modifier.height(24.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                if(lastFinal != totalFinal.value) {
                    lastFinal = totalFinal.value
                    saveEnabled = true
                }
                Text(
                    text = "Total por persona ${
                        FormatUtils.formatDoubleToMexicanCurrency(
                            totalFinal.value
                        )
                    }"
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {
                val message = FormatUtils.formatShareMessage(
                    amount = totalText.toDoubleOrNull() ?: 0.0,
                    tip = tipText.toDoubleOrNull() ?: 0.0,
                    people = peopleText.toIntOrNull() ?: 1,
                    totalPerPerson = totalFinal.value
                )
                actions.onShareClick(message)
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Compartir")
            }
            Button(
                onClick = {
                    val bill = SplitedBill(
                        date = java.time.LocalDateTime.now(),
                        amount = totalText.toDoubleOrNull() ?: 0.0,
                        people = peopleText.toIntOrNull() ?: 1,
                        tipType = tipType
                    )
                    actions.onSaveClick(bill)
                    saveEnabled = false
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = saveEnabled
            ) {
                Text(text = "Guardar")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CalculatorScreenPreview() {
    CooperachAppTheme {
        CalculatorScreen(CalculatorActions())
    }
}
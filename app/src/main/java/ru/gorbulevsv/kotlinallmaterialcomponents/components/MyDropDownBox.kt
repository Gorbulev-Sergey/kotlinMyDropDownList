package ru.gorbulevsv.kotlinallmaterialcomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyDropDownBox(items: List<String>, selectedItem: MutableState<String>) {
    var isDialogShow by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .background(
                MaterialTheme.colorScheme.primary.copy(.05f),
                shape = RoundedCornerShape(5.dp)
            )
            .fillMaxWidth()
            .clickable(onClick = { isDialogShow = true })
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = selectedItem.value)
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = ""
            )
        }

        if (isDialogShow) {
            AlertDialog(
                title = {
                    Text(
                        text = "Выбери город",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                text = {
                    Column {
                        for (i in items) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        if (i == selectedItem.value) {
                                            MaterialTheme.colorScheme.secondary.copy(
                                                .1f
                                            )
                                        } else {
                                            Color.Transparent
                                        }
                                    )
                                    .fillMaxWidth()
                                    .clickable(onClick = {
                                        selectedItem.value = i
                                        isDialogShow = false
                                    })
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp, 10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = i, fontSize = 16.sp)
                                }
                            }

                        }
                    }
                },
                onDismissRequest = {
                    isDialogShow = false
                },
                confirmButton = {},
                dismissButton = {},
                shape = RoundedCornerShape(10.dp)
            )
        }
    }
}
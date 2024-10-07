package ru.gorbulevsv.kotlinallmaterialcomponents

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.gorbulevsv.kotlinallmaterialcomponents.ui.theme.KotlinAllMaterialComponentsTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableInteractionSource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinAllMaterialComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Column(modifier = Modifier.padding(10.dp)) {


                            var isDialogShow by remember { mutableStateOf(false) }
                            var items = listOf(
                                "Москва",
                                "Калуга",
                                "Санкт-Петербург",
                                "Новосибирск",
                                "Геленджик"
                            )
                            var selectedItem by remember { mutableStateOf(items[0]) }
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
                                    Text(text = selectedItem)
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
                                                                if (i == selectedItem) {
                                                                    MaterialTheme.colorScheme.secondary.copy(
                                                                        .1f
                                                                    )
                                                                } else {
                                                                    Color.Transparent
                                                                }
                                                            )
                                                            .fillMaxWidth()
                                                            .clickable(onClick = {
                                                                selectedItem = i
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
                    }
                }
            }
        }
    }
}



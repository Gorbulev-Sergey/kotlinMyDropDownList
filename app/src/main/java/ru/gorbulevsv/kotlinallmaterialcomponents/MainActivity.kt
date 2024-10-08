package ru.gorbulevsv.kotlinallmaterialcomponents

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.gorbulevsv.kotlinallmaterialcomponents.ui.theme.KotlinAllMaterialComponentsTheme
import ru.gorbulevsv.kotlinallmaterialcomponents.components.MyDropDownBox
import ru.gorbulevsv.kotlinallmaterialcomponents.components.MyDropDownFonts

class MainActivity : ComponentActivity() {
    var selectedItem = mutableStateOf(0)
    var items = listOf<Pair<String, Int>>(
        Pair("Inter", R.font.inter),
        Pair("Manrope", R.font.manrope),
        Pair("Montserrat", R.font.montserrat),
        Pair("Open Sans", R.font.open_sans),
        Pair("Oswald", R.font.oswald),
        Pair("PT Sans", R.font.pt_sans),
        Pair("PT Serif", R.font.pt_serif),
        Pair("Raleway", R.font.raleway),
        Pair("Rubik", R.font.rubik)
    )

    var items2 = listOf(
        "Красный",
        "Синий",
        "Зелёный",
        "Голубой",
        "Оранжевый"
    )
    var selectedItem2 = mutableStateOf(items2[0])

    @SuppressLint("UnrememberedMutableInteractionSource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinAllMaterialComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Column(
                            modifier = Modifier.padding(10.dp),
                            verticalArrangement = Arrangement.spacedBy(5.dp)
                        ) {


                            MyDropDownFonts(items, selectedItem)
                            MyDropDownBox(items2, selectedItem2)
                        }
                    }
                }
            }
        }
    }
}



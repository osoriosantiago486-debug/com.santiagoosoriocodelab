package com.ucaldas.comsantiagosoriocodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ucaldas.comsantiagosoriocodelab.R
import com.ucaldas.comsantiagosoriocodelab.ui.theme.ComsantiagosoriocodelabTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComsantiagosoriocodelabTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {

    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {

    // Guarda el resultado del dado.
    var result by remember { mutableStateOf(1) }

    // Selecciona la imagen correspondiente al resultado.
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Muestra la imagen correspondiente al resultado.
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        Text(
            text = "Santiago Osorio"
        )
        // Deja espacio entre el dado y el botón.
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Genera un número aleatorio entre 1 y 6.
                result = (1..6).random()
            }
        ) {
            Text(stringResource(R.string.roll))
        }
    }
}
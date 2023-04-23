package pl.put.poznan.michalxpz.compose_snippets.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CounterRotationSensitive() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // wartość timesClicked zostanie zresetowana przy zmianie orientacji
        var timesClicked by remember { mutableStateOf(0) }
        Text(text = "Clicked: $timesClicked")
        Button(onClick = { timesClicked++ }) {
            Text(text = "Click me")
        }
    }
}

@Composable
fun CounterRotationAware() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // wartość timesClicked utrzyma się przy zmianie orientacji
        var timesClicked by rememberSaveable { mutableStateOf(0) }
        Text(text = "Clicked: $timesClicked")
        Button(onClick = { timesClicked++ }) {
            Text(text = "Click me")
        }
    }
}
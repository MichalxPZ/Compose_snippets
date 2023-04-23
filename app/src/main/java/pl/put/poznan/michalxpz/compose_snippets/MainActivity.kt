package pl.put.poznan.michalxpz.compose_snippets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.put.poznan.michalxpz.compose_snippets.list.MyList
import pl.put.poznan.michalxpz.compose_snippets.ui.theme.Compose_snippetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_snippetsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyList(names = listOf("Basia", "Kasia", "Ola", "Bartek", "Michał", "Klaudia"))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    Compose_snippetsTheme {
        MyList(names = listOf("Basia", "Kasia", "Ola", "Bartek", "Michał", "Klaudia"))
    }
}
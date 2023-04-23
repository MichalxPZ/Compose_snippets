package pl.put.poznan.michalxpz.compose_snippets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pl.put.poznan.michalxpz.compose_snippets.screens.Screen1
import pl.put.poznan.michalxpz.compose_snippets.screens.Screen2
import pl.put.poznan.michalxpz.compose_snippets.screens.Screen3
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
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "screen1") {
                        composable("screen1") {
                            Screen1(
                                { navController.navigate("screen2") },
                                { navController.navigate("screen3?text=navigatedFromScreen1") },
                            )
                        }
                        composable("screen2") {
                            Screen2(
                                { navController.navigate("screen1") },
                                { navController.navigate("screen3?text=navigatedFromScreen2") },
                            )
                        }
                        composable("screen3?text={text}",
                            arguments = listOf(navArgument("text") {defaultValue = "Three"})
                            ) { backStackEntry ->
                            Screen3(
                                backStackEntry.arguments?.getString("text"),
                                { navController.navigate("screen1") },
                                { navController.navigate("screen2") }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_snippetsTheme {
        Greeting("Android")
    }
}
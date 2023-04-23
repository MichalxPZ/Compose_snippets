package pl.put.poznan.michalxpz.compose_snippets.lazy_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleList(items: List<String>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = listModifier()
    ) {
        items.forEach { item ->
            Text(item)
        }
    }
}

@Composable
fun SimpleLazyList(items: List<String>) {
    LazyColumn(
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = listModifier()
    ) {
        items(items) { item ->
            Text(item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleListPreview() {
    val list = (1..100).toList().map { it.toString() }
    SimpleLazyList(list)
}

@Preview(showBackground = true)
@Composable
fun SimpleLazyListPreview() {
    val list = (1..100).toList().map { it.toString() }
    SimpleList(list)
}


@Composable
fun listModifier() = Modifier.fillMaxSize(1F)
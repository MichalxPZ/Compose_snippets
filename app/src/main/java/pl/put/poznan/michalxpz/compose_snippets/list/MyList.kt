package pl.put.poznan.michalxpz.compose_snippets.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyList(names: List<String>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Names list",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(8.dp)
        )
        LazyColumn(modifier = Modifier
            .wrapContentSize()
            .align(Alignment.CenterHorizontally)) {
            itemsIndexed(names) { index, item ->
                Row(
                    modifier = Modifier.wrapContentSize(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = index.toString(), modifier = Modifier.padding(end = 24.dp))

                    Text(text = item)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyListPreview() {
    val names = listOf("Basia", "Kasia", "Ola", "Bartek", "Michał", "Klaudia")
    MyList(names)
}
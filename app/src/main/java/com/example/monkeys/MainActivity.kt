package com.example.monkeys

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.monkeys.ui.theme.MonkeysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MonkeysTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CharacterButtonLayout(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}
@Composable
fun CharacterButtonLayout(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Row(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CharacterButton(
            image = painterResource(id = R.drawable.monkey1),
            description = "Персонаж 1",
            onClick = {
                Toast.makeText(context, "Вы выбрали 1", Toast.LENGTH_SHORT).show()
            }
        )
        CharacterButton(
            image = painterResource(id = R.drawable.monkey2),
            description = "Персонаж 2",
            onClick = {
                Toast.makeText(context, "Вы выбрали 2", Toast.LENGTH_SHORT).show()
            }
        )
        CharacterButton(
            image = painterResource(id = R.drawable.monkey3),
            description = "Персонаж 3",
            onClick = {
                Toast.makeText(context, "Вы выбрали 3", Toast.LENGTH_SHORT).show()
            }
        )
    }
}
@Composable
fun CharacterButton(image: Painter, description: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(150.dp)
            .height(300.dp),
        shape = MaterialTheme.shapes.small,
        contentPadding = PaddingValues(0.dp)
    ) {
        Image(
            painter = image,
            contentDescription = description,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}
@Preview(showBackground = true)
@Composable
fun CharacterButtonLayoutPreview() {
    MonkeysTheme {
        CharacterButtonLayout()
    }
}

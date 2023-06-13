package com.example.StateWorking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.StateWorking.ui.theme.BoxEExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            BoxEExampleTheme {
                var items by remember{
                    mutableStateOf(
                        (1..20).map(){
                            ListItems (
                                title= "title $it",
                                isSelected= false)
                        }
                    )
                }
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)

                    ) {
                        LazyColumn(modifier = Modifier.fillMaxSize()){
                            items(items.size){i ->
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        items = items.mapIndexed { j, item ->
                                            if (i == j) {
                                                item.copy(isSelected = !item.isSelected)

                                            } else item
                                        }
                                    }
                                    .padding(16.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(text = items[i].title, fontSize = 24.sp, color = Color.Blue)
                                    if (items[i].isSelected){
                                        Icon(imageVector = Icons.Default.Create, contentDescription = "selected",
                                        tint = Color.Blue,
                                            modifier = Modifier.size(30.dp)
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BoxEExampleTheme {

    }
}
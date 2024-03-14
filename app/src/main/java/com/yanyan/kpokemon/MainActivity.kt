package com.yanyan.kpokemon

import android.annotation.SuppressLint
import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.yanyan.kpokemon.ui.theme.KpokemonTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var count by mutableIntStateOf(0);

        setContent {
            Scaffold(
                floatingActionButton = {
                    CustomFloatingActionButton(onClickAction = {
                        count++
                    })
                }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().background(Color.Cyan),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = "Count: $count")

                }
            }

        }
    }
}



@Composable
fun CustomFloatingActionButton(onClickAction: ()->Unit){
    FloatingActionButton(
        onClick = onClickAction,
        content = { Icon(Icons.Default.Add, contentDescription = "Add") }
    )
}
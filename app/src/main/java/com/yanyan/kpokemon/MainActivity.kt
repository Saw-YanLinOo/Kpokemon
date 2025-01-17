package com.yanyan.kpokemon

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yanyan.kpokemon.data.remote.responses.Pokemon
import com.yanyan.kpokemon.pokemonlist.PokemonListScreen
import com.yanyan.kpokemon.ui.theme.KpokemonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            KpokemonTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "pokemon_list_screen"
                ){
                    composable("pokemon_list_screen"){
                        PokemonListScreen(navController)
                    }
                    composable(
                        "pokemon_detail_screen",
                        arguments = listOf(
                            navArgument("dominantColor"){
                                type = NavType.IntType
                            },
                            navArgument("pokemonName"){
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val dominantColor = remember {
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let { Color(color) }?: Color.White

                        }
                        val pokemonName = remember {
                            it.arguments?.getString("pokemonName")
                        }



                    }
                }

            }
        }
    }
}

package com.yanyan.kpokemon.data.remote

import com.yanyan.kpokemon.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAPI {
    @GET("/api/v2/pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit:Int,
        @Query("offset") offset: Int,
    ): PokemonList

    @GET("/api/v2/pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name:String
    ):Pokemon
}
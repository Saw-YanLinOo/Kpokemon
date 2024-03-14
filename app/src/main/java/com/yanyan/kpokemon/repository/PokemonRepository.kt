package com.yanyan.kpokemon.repository

import com.yanyan.kpokemon.data.remote.PokemonAPI
import com.yanyan.kpokemon.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokemonAPI
){
    suspend fun getPokemonList(limit:Int,offset:Int):Resource<PokemonList>{
        val response = try {
            api.getPokemonList(limit,offset)
        }catch (e:Exception){
            return  Resource.Error("Something went wrong !!");
        }

        return  Resource.Success(response)
    }

    suspend fun getPokemonDetail(name:String):Resource<Pokemon>{
        val response = try {
            api.getPokemonDetail(name)
        }catch (e:Exception){
            return  Resource.Error("Something went wrong !!");
        }

        return  Resource.Success(response)
    }
}
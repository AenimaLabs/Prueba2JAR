package com.example.prueba2jar.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prueba2jar.data.Games
import com.example.prueba2jar.data.GamesDetail
import com.example.prueba2jar.remote.RetrofitClient
import kotlinx.coroutines.launch

class GamesViewModel : ViewModel() {


    private val gamelist = MutableLiveData<List<Games>>()

    fun gamelist() : LiveData<List<Games>> = gamelist

    fun getGames() {
        viewModelScope.launch {
            val response = RetrofitClient.retrofitInstance().getGames()

            Log.d("PokeViewModel", "cargando info")

            response.let {
                when(it.isSuccessful) {
                    true -> gamelist.value = response.body()
                    false -> Log.d("PokeViewModel", "epa! error")
                }
            }
        }
    }


    private val detail = MutableLiveData<GamesDetail>()
    fun getDetail(): LiveData<GamesDetail> = detail

    fun getDetail(id: Int) {




        viewModelScope.launch {
            val response = RetrofitClient.retrofitInstance().getGames(id.toString())
            Log.d("PokeViewModel", "cargando detalle para $id")

            Log.d("PokeViewModel", response.body().toString())

            if(response.isSuccessful) {
                detail.value = response.body()
            } else {
                Log.d("PokeViewModel", "epa! error en el detalle ${response.code()}")
            }
        }
    }


    private lateinit var selected : Games

    fun setSelected(pokemon: Games) {
        selected = pokemon
    }

    fun getSelected() = selected
}
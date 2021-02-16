package com.example.prueba2jar.data

import com.example.prueba2jar.remote.GameAPI
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path



interface GamesAPI {
    @GET("games")
    suspend fun getGames(): Response<List<Games>>

    @GET("gamesDetails/{id}")
    suspend fun getGames (@Path("id") id:Int): Response<GamesDetail>
}

class RetrofitClient {
    companion object {
        private const val BASE_URL = "https://my-json-server.typicode.com/himuravidal/gamesDB/"

        fun retrofitInstance(): GamesAPI {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create())
                .build()

            return retrofit.create(GamesAPI::class.java)
        }
    }
}


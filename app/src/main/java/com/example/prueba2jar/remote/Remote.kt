package com.example.prueba2jar.remote

import com.example.prueba2jar.data.Games
import com.example.prueba2jar.data.GamesDetail
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path



interface GameAPI {
    @GET("pokemon")
    suspend fun getGames(): Response<List<Games>>

    @GET("pokemon/{pid}")
    suspend fun getGames(@Path("id") id: String): Response<GamesDetail>
}

class RetrofitClient {
    companion object {
        private const val BASE_URL =  "https://my-json-server.typicode.com/himuravidal/gamesDB/"

        fun retrofitInstance(): GameAPI {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create())
                .build()

            return retrofit.create(GameAPI::class.java)
        }
    }
}


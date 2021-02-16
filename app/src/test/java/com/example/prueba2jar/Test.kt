package com.example.prueba2jar

import com.example.prueba2jar.data.Games
import com.example.prueba2jar.data.GamesAPI
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Test {

    lateinit var mMockWebServer: MockWebServer
    lateinit var gamesApi : GamesAPI

    @Before
    fun setUp() {
        mMockWebServer = MockWebServer()
        val retro = Retrofit.Builder()
            .baseUrl(mMockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        gamesApi =  retro.create(GamesAPI::class.java)
    }

    @After
    fun shutDown() {
        mMockWebServer.shutdown()
    }

    @Test
    fun getBooks() = runBlocking {
        //given
        val mResultList = listOf(Games(4200,"Portal 2","2011-04-18","https://media.rawg.io/media/games/328/3283617cb7d75d67257fc58339188742.jpg",4.62,95))
        mMockWebServer.enqueue(MockResponse().setBody(Gson().toJson(mResultList)))

        //when
        val result = gamesApi.getGames()

        //then
        assertThat(result).isNotNull





    }
}
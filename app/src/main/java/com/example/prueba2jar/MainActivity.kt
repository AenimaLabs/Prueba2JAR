package com.example.prueba2jar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.prueba2jar.databinding.ActivityMainBinding
import com.example.prueba2jar.viewmodel.GamesViewModel

class MainActivity : AppCompatActivity() {

    val gameVM : GamesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gameVM.getGames()


    }
}
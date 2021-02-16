package com.example.prueba2jar.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.prueba2jar.databinding.FragmentDetailBinding
import com.example.prueba2jar.viewmodel.GamesViewModel

class DetailFragment: Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private val gamesViewModel: GamesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)


        val games = gamesViewModel.getSelected()
        Log.d("DetailFragment", "$games")


        gamesViewModel.getDetail(games.id)

        gamesViewModel.getDetail().observe(viewLifecycleOwner, {
            binding.name.text = it.name
            binding.gameid.text = it.id.toString()
        })

        return binding.root
    }
}
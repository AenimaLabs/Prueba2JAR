package com.example.prueba2jar.listing

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.prueba2jar.R

import com.example.prueba2jar.databinding.FragmentListingBinding
import com.example.prueba2jar.detail.DetailFragment
import com.example.prueba2jar.viewmodel.GamesViewModel

class ListingFragment : Fragment() {

    private lateinit var binding: FragmentListingBinding

    private val gamesViewModel: GamesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListingBinding.inflate(inflater)


        val adapter = PokeAdapter()
        binding.gameList.adapter = adapter
        // OJO, pestaña y ceja -> si no se ve la info en el recyclerview
        binding.gameList.layoutManager = GridLayoutManager(context, 1)

        gamesViewModel.gamelist().observe(viewLifecycleOwner, {
            Log.d("ListingFragment", "actualizando info de games ${it.size}")
            adapter.update(it)
        })

        adapter.selectedItem().observe(viewLifecycleOwner, {
            Log.d("ListingFragment", "elemento seleccionado $it")

            gamesViewModel.setSelected(it)

            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_container, DetailFragment())?.addToBackStack("detail")?.commit()
        })



        return binding.root
    }
}
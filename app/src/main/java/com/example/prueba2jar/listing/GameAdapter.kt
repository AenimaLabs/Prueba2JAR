package com.example.prueba2jar.listing

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba2jar.data.Games

import com.example.prueba2jar.databinding.GameItemBinding

class PokeAdapter: RecyclerView.Adapter<GameVH>() {

    private var gamelist = listOf<Games>()

    private val selectedItem = MutableLiveData<Games>()

    fun selectedItem(): LiveData<Games> = selectedItem

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameVH {
        val binding = GameItemBinding.inflate(LayoutInflater.from(parent.context))

        return GameVH(binding)
    }

    override fun onBindViewHolder(holder: GameVH, position: Int) {
        val game = gamelist[position]
        holder.bind(game)
        holder.itemView.setOnClickListener {
            Log.d("GameAdapter", "elemento seleccionado $game")
            selectedItem.value = game
        }
    }

    override fun getItemCount() = gamelist.size

    fun update(ggame: List<Games>) {
        gamelist = ggame
        notifyDataSetChanged()
    }
}

class GameVH(val binding: GameItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(games: Games) {
        binding.textView.text = games.name
    }
}

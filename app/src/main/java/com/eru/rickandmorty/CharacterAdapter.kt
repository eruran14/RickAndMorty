package com.eru.rickandmorty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eru.rickandmorty.databinding.ItemCharacterBinding

class CharacterAdapter(private val data: ArrayList<Character>, private val onClick: (pos: Int) -> Unit): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = data.size

    private fun getCharacter(position: Int) = data[position]

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(){
            binding.charName.text = getCharacter(adapterPosition).name
            binding.charStatus.text = getCharacter(adapterPosition).status
            binding.charImage.setBackgroundResource(getCharacter(adapterPosition).image)

            binding.root.setOnClickListener {
                onClick(adapterPosition)
            }
        }
    }
}
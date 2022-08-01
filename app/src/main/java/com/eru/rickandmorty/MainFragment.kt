package com.eru.rickandmorty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.eru.rickandmorty.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val data = arrayListOf<Character>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        data.add(Character("Alive", "Rick Sanchez", R.drawable.rick_image))
        data.add(Character("Alive", "Morty Smith", R.drawable.morty_image))
        data.add(Character("Dead", "Albert Einstein", R.drawable.einstein_image))
        data.add(Character("Alive", "Jerry Smith", R.drawable.jerry_image))

        val adapter = CharacterAdapter(data){
            findNavController().navigate(R.id.action_mainFragment_to_secondFragment, Bundle().apply {
                putSerializable("key1", data[it])
            })
        }

        binding.recycler.adapter = adapter
    }
}
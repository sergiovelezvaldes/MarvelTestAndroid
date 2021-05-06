package com.example.testmarvel.ui.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testmarvel.R
import com.example.testmarvel.domain.character.model.Character
import com.example.testmarvel.ui.common.RecyclerViewClickListener
import com.example.testmarvel.ui.common.extensions.hideKeyboard
import com.example.testmarvel.ui.common.model.ViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.character_fragment.*

@AndroidEntryPoint
class CharacterFragment : Fragment(R.layout.character_fragment), RecyclerViewClickListener {

    private val viewModel: CharacterViewModel by viewModels()
    private var characters: List<Character> = listOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.loadCharacters()
        initObservers()
    }

    private fun initObservers() {
        observeCharactersViewState()
    }

    private fun observeCharactersViewState(){
        viewModel.charactersViewState.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is ViewState.Loading -> {
                    // TODO
                }
                is ViewState.Data -> {
                    hideKeyboard()
                    CharacterList.also {
                        characters = state.data
                        it.layoutManager = LinearLayoutManager(context)
                        it.setHasFixedSize(true)
                        it.adapter = CharacterAdapter(characters, this, requireContext())
                    }
                }
                is ViewState.Failure -> {
                    // TODO
                }
            }
        })
    }

    override fun <T> onRecyclerViewItemClick(view: View, item: T) {
        val character = item as Character
        val action = CharacterFragmentDirections.goToDetailFragment()
        action.idCharacter = character.id
        view.findNavController().navigate(action)
    }

}
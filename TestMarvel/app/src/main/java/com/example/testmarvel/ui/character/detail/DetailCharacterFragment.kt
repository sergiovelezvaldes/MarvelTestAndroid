package com.example.testmarvel.ui.character.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testmarvel.R
import com.example.testmarvel.ui.character.CharacterAdapter
import com.example.testmarvel.ui.character.CharacterViewModel
import com.example.testmarvel.ui.common.extensions.download
import com.example.testmarvel.ui.common.extensions.hideKeyboard
import com.example.testmarvel.ui.common.model.ViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.character_fragment.*
import kotlinx.android.synthetic.main.content_collapsing.*
import kotlinx.android.synthetic.main.fragment_detail_character.*

@AndroidEntryPoint
class DetailCharacterFragment : Fragment(R.layout.fragment_detail_character) {

    private val args: DetailCharacterFragmentArgs by navArgs()
    private val viewModel: CharacterViewModel by viewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.loadCharacterById(args.idCharacter)
        observeCharacterViewState()

        backButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_detailCharacterFragment_to_characterFragment)
        }
    }

    private fun observeCharacterViewState(){
        viewModel.characterViewState.observe(viewLifecycleOwner, { state ->
            when (state) {
                is ViewState.Loading -> {
                    // TODO
                }
                is ViewState.Data -> {
                    hideKeyboard()
                    toolbarLayout.title = state.data.name
                    summaryCharacter.text = state.data.description
                }
                is ViewState.Failure -> {
                    // TODO
                }
            }
        })
    }
}
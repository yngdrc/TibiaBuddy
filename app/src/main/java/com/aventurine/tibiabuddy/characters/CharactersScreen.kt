package com.aventurine.tibiabuddy.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersScreen(
    charactersViewModel: CharactersViewModel
) {
    val searchQuery = charactersViewModel.searchQuery.collectAsState()

    Scaffold(
        topBar = {
            SearchBar(
                query = searchQuery.value,
                onQueryChange = { charactersViewModel.searchQuery.value = it},
                onSearch = charactersViewModel::getCharacter,
                active = true,
                onActiveChange = {}
            ) {
                LazyColumn {
                    items(count = charactersViewModel.characters.size) {
                        val character = charactersViewModel.characters[it]
                        Column {
                            Text(text = character.name)
                            Text(text = character.vocation)
                            Text(text = "${character.level}")
                            Text(text = character.residence)
                            Text(text = character.world)
                            Text(text = character.lastLogin)
                        }
                    }
                }
            }
        }
    ) { paddingValues ->

    }
}
package com.example.retrofittestmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittestmvvm.repository.MemesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemesViewModel(private val memesRepository: MemesRepository) : ViewModel() {

    val memes = memesRepository.memes


    init {
        viewModelScope.launch(Dispatchers.IO) {
            memesRepository.getJokes()
        }
    }

}
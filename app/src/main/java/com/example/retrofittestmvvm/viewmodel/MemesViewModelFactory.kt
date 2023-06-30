package com.example.retrofittestmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofittestmvvm.repository.MemesRepository

class MemesViewModelFactory(private val memesRepository: MemesRepository) :
ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MemesViewModel(memesRepository) as T
    }
}
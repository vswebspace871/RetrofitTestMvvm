package com.example.retrofittestmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofittestmvvm.api.ApiInterface
import com.example.retrofittestmvvm.model.Jokes

class MemesRepository(val apiInterface: ApiInterface) {

    val memesLivedata = MutableLiveData<Jokes>()

    val memes : LiveData<Jokes>
    get() = memesLivedata

    suspend fun getJokes() {

        val response = apiInterface.getJokes()
        if (response.body() != null){
                memesLivedata.postValue(response.body())
        }
    }

}
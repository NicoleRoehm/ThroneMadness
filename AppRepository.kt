package com.example.apicalls.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apicalls.data.model.GotCharacter
import com.example.apicalls.data.remote.GotApi

class AppRepository (
    private val api:GotApi) {
        private val _characters = MutableLiveData<List<GotCharacter>>()
        val characters :LiveData<List<GotCharacter>>
        get() = _characters

    suspend fun loadCharacters(){
        _characters.value = api.retrofitService.getCharacters()
    }
    }


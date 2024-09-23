package com.ppdm.app_ejercicio_2.modelos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MusicViewModel : ViewModel() {
    private val _selectedMusicIndex = MutableLiveData<Int>()
    val selectedMusicIndex: LiveData<Int> get() = _selectedMusicIndex

    fun selectMusic(index: Int) {
        _selectedMusicIndex.value = index
    }
}
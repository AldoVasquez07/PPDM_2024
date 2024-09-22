package com.ppdm.app_ejercicio_1.modelos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageViewModel : ViewModel() {
    private val _selectedImageIndex = MutableLiveData<Int>()
    val selectedImageIndex: LiveData<Int> get() = _selectedImageIndex

    fun selectImage(index: Int) {
        _selectedImageIndex.value = index
    }
}

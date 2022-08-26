package com.example.secondscreen.presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.secondscreen.domain.usecase.GetImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondViewModel@Inject constructor(
    private val imageUseCase: GetImagesUseCase
) : ViewModel() {

    private val _image = MutableStateFlow<List<String>?>(null)
    var images = _image.asStateFlow()


    fun getImages(){
        viewModelScope.launch() {
            imageUseCase.invoke().collectLatest {
                _image.value = it
            }
        }
    }
}
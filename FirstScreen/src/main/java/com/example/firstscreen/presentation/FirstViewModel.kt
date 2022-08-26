package com.example.firstscreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstscreen.domain.model.MyModel
import com.example.firstscreen.domain.usecase.GetDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val getDataUseCase: GetDataUseCase) : ViewModel() {

    private val _user = MutableStateFlow<MyModel?>(null)
    var user = _user.asStateFlow()

    private val io = Dispatchers.IO

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch(io) {
            getDataUseCase.invoke().collectLatest {
                _user.value = it
            }
        }
    }


}
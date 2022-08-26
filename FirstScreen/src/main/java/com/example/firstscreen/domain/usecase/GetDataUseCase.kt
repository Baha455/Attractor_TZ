package com.example.firstscreen.domain.usecase

import com.example.firstscreen.domain.model.MyModel
import com.example.firstscreen.domain.model.User
import com.example.firstscreen.domain.remote.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDataUseCase @Inject constructor(private val repository: Repository) {

    fun invoke():Flow<MyModel> = repository.getData()
}
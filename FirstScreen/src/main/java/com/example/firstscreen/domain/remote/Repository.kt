package com.example.firstscreen.domain.remote

import com.example.firstscreen.domain.model.MyModel
import com.example.firstscreen.domain.model.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Response


interface Repository {

     fun getData(): Flow<MyModel>

}
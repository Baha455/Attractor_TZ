package com.example.firstscreen.domain.remote

import com.example.firstscreen.domain.model.MyModel
import com.example.firstscreen.domain.model.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {

    @GET("Baha455/mockend/db")
    suspend fun getData(): Response<MyModel>

}
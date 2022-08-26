package com.example.firstscreen.data.repository

import com.example.firstscreen.domain.model.MyModel
import com.example.firstscreen.domain.remote.Repository
import com.example.firstscreen.domain.remote.ServiceApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(private val serviceApi: ServiceApi): Repository {

    override fun getData(): Flow<MyModel> {
        return flow {
            val response = serviceApi.getData()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    emit(body)
                }
            }
        }
    }
}

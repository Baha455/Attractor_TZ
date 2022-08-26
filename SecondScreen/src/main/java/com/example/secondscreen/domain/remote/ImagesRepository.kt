package com.example.secondscreen.domain.remote

import kotlinx.coroutines.flow.Flow


interface ImagesRepository {

    fun getImages(): Flow<List<String>>
}
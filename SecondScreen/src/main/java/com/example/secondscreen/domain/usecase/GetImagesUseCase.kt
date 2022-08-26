package com.example.secondscreen.domain.usecase

import com.example.secondscreen.data.repository.ImagesRepositoryImpl
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(private val repository: ImagesRepositoryImpl) {

    fun invoke() = repository.getImages()

}
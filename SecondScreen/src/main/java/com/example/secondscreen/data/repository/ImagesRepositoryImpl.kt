package com.example.secondscreen.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import com.example.secondscreen.domain.remote.ImagesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.abs
import kotlin.random.Random

@Singleton
class ImagesRepositoryImpl @Inject constructor(val context: Context): ImagesRepository {

    @SuppressLint("Recycle")
    override fun getImages(): Flow<List<String>> {
        return flow {
            val cursor: Cursor
            val listOfAllImages: ArrayList<String> = ArrayList()
            var absolutePathOfImage: String
            val uri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

            val projection =
                arrayOf(MediaStore.MediaColumns.DATA, MediaStore.Images.Media.BUCKET_DISPLAY_NAME)
            val orderBy: String = MediaStore.Images.Media.DATE_TAKEN
            cursor = context.contentResolver.query(uri, projection, null, null, orderBy + " DESC")!!
            val columnIndexData: Int = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)

            val random = Random.nextInt(2, 30)

            for (i in 0..random){
                cursor.moveToNext()
                absolutePathOfImage = cursor.getString(columnIndexData)
                listOfAllImages.add(absolutePathOfImage)
            }



            emit(listOfAllImages)
        }
    }
}
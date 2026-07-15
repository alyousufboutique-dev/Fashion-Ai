package com.fashionai.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File

object ImageUtils {
    fun loadBitmapFromFile(filePath: String, targetWidth: Int = 224): Bitmap? {
        return try {
            val options = BitmapFactory.Options().apply {
                inSampleSize = calculateInSampleSize(filePath, targetWidth, targetWidth)
            }
            BitmapFactory.decodeFile(filePath, options)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun calculateInSampleSize(filePath: String, reqWidth: Int, reqHeight: Int): Int {
        val options = BitmapFactory.Options().apply {
            inJustDecodeBounds = true
        }
        BitmapFactory.decodeFile(filePath, options)

        var inSampleSize = 1
        if (options.outHeight > reqHeight || options.outWidth > reqWidth) {
            val halfHeight = options.outHeight / 2
            val halfWidth = options.outWidth / 2

            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }
        return inSampleSize
    }

    fun compressBitmap(bitmap: Bitmap, quality: Int = 85): ByteArray {
        val outputStream = java.io.ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream)
        return outputStream.toByteArray()
    }
}

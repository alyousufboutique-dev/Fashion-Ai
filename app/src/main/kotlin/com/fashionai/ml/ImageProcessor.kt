package com.fashionai.ml

import android.graphics.Bitmap
import android.graphics.ImageFormat
import android.media.Image
import java.nio.ByteBuffer

class ImageProcessor {
    fun processBitmap(bitmap: Bitmap, inputSize: Int = 224): FloatArray {
        val resizedBitmap = Bitmap.createScaledBitmap(bitmap, inputSize, inputSize, true)
        return bitmapToFloatArray(resizedBitmap)
    }

    private fun bitmapToFloatArray(bitmap: Bitmap): FloatArray {
        val floatValues = FloatArray(bitmap.width * bitmap.height * 3)
        val pixels = IntArray(bitmap.width * bitmap.height)
        bitmap.getPixels(pixels, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)

        var index = 0
        for (pixel in pixels) {
            floatValues[index++] = ((pixel shr 16) and 0xFF) / 255.0f // R
            floatValues[index++] = ((pixel shr 8) and 0xFF) / 255.0f  // G
            floatValues[index++] = (pixel and 0xFF) / 255.0f          // B
        }

        return floatValues
    }

    fun imageToByteBuffer(image: Image): ByteBuffer {
        val buffer = ByteBuffer.allocateDirect(image.width * image.height * 3)
        val planes = image.planes
        val ySize = planes[0].buffer.remaining()
        val uvSize = planes[1].buffer.remaining()

        val nv21 = ByteArray(ySize + uvSize)
        planes[0].buffer.get(nv21, 0, ySize)
        planes[1].buffer.get(nv21, ySize, uvSize)

        return buffer
    }
}

package com.fashionai.ml

import android.content.Context
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.gpu.CompatibilityList
import org.tensorflow.lite.gpu.GpuDelegate
import org.tensorflow.lite.nnapi.NnApiDelegate
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

class TensorFlowLiteHelper(private val context: Context) {
    private var interpreter: Interpreter? = null
    private var gpuDelegate: GpuDelegate? = null

    fun loadModel(modelPath: String) {
        try {
            val modelBuffer = loadModelFile(modelPath)
            val options = Interpreter.Options()

            // Try to use GPU delegate if available
            if (CompatibilityList().isDelegateSupportedOnThisDevice) {
                gpuDelegate = GpuDelegate()
                options.addDelegate(gpuDelegate)
            } else {
                // Fall back to NNAPI
                options.addDelegate(NnApiDelegate())
            }

            interpreter = Interpreter(modelBuffer, options)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun loadModelFile(modelPath: String): MappedByteBuffer {
        val assetFileDescriptor = context.assets.openFd(modelPath)
        val inputStream = FileInputStream(assetFileDescriptor.fileDescriptor)
        val fileChannel = inputStream.channel
        val startOffset = assetFileDescriptor.startOffset
        val declaredLength = assetFileDescriptor.declaredLength
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
    }

    fun predictClothingType(input: FloatArray): FloatArray {
        val output = FloatArray(7) // 7 clothing types
        interpreter?.run(input, output)
        return output
    }

    fun predictColor(input: FloatArray): FloatArray {
        val output = FloatArray(10) // 10 common colors
        interpreter?.run(input, output)
        return output
    }

    fun close() {
        interpreter?.close()
        gpuDelegate?.close()
    }
}

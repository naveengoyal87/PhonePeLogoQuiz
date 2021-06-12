package com.example.logoquiz.data

import android.content.Context
import android.util.Log
import com.example.logoquiz.R
import com.example.logoquiz.data.model.LogoModel
import com.example.logoquiz.data.model.LogoResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.lang.reflect.Type


object LogoQuizDataRetriver {

    private const val FILENAME = "logo.txt"
    private fun getLogoStream(context: Context): InputStream {
        return context.resources.openRawResource(
            R.raw.logo
//            context.resources.getIdentifier(
//                FILENAME,
//                "raw", context.packageName
//            )
        )
    }

    fun getLogoData(context: Context): LogoResponse {
        val outputStream = ByteArrayOutputStream()
        val buffer = ByteArray(1024)

        val inputStream: InputStream = getLogoStream(context)

        try {
            var length: Int
            while (-1 != inputStream.read(buffer).also { length = it }) {
                outputStream.write(buffer, 0, length)
            }
        } catch (e: IOException) {
            Log.e("LogoQuiz", "Exception when reading JSON", e)
        }

        var byteArray = outputStream.toByteArray()

        val gson = Gson()
        val jsonOutput = String(byteArray)
        val listType: Type = object : TypeToken<List<LogoModel>?>() {}.type
        val posts = gson.fromJson<List<LogoModel>?>(jsonOutput, listType)

        return LogoResponse(posts)
    }
}
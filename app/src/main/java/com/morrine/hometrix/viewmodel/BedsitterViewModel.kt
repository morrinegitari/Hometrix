package com.morrine.hometrix.viewmodel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.morrine.hometrix.data.BedsitterDatabase
import com.morrine.hometrix.model.Bedsitter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class BedsitterViewModel(app: Application) : AndroidViewModel(app) {

    private val context = app.applicationContext
    private val bedsitterDao = BedsitterDatabase.getDatabase(app).bedsitterDao()

    val allBedsitter: LiveData<List<Bedsitter>> = bedsitterDao.getAllBedsitter()

    fun addBedsitter(name: String,  phone: String,location: String,bedroom: String,bathroom: String,price: Double, imageUri: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val savedImagePath = saveImageToInternalStorage(Uri.parse(imageUri))
            val newBedsitter = Bedsitter(
                name = name,
                location = location,
                bedroom = bedroom,
                bathroom = bathroom,
                price = price,
                phone = phone,
                imagePath = savedImagePath // use saved image path
            )
            bedsitterDao.insertBedsitter(newBedsitter)
        }
    }

    fun updateBedsitter(updatedBedsitter: Bedsitter) {
        viewModelScope.launch(Dispatchers.IO) {
            bedsitterDao.updateBedsitter(updatedBedsitter)
        }
    }

    fun deleteBedsitter(bedsitter: Bedsitter) {
        viewModelScope.launch(Dispatchers.IO) {
            // Delete image from storage
            deleteImageFromInternalStorage(bedsitter.imagePath)
            bedsitterDao.deleteBedsitter(bedsitter)
        }
    }

    // Save image permanently to internal storage
    private fun saveImageToInternalStorage(uri: Uri): String {
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        val fileName = "IMG_${System.currentTimeMillis()}.jpg"
        val file = File(context.filesDir, fileName)

        inputStream?.use { input ->
            FileOutputStream(file).use { output ->
                input.copyTo(output)
            }
        }

        return file.absolutePath
    }

    private fun deleteImageFromInternalStorage(path: String) {
        try {
            val file = File(path)
            if (file.exists()) {
                file.delete()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

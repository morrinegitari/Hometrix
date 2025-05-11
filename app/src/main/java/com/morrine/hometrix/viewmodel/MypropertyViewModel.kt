package com.morrine.hometrix.viewmodel

import android.app.Application
import android.location.Location
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.morrine.hometrix.data.MypropertyDatabase
import com.morrine.hometrix.model.Myproperty

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import kotlin.io.copyTo
import kotlin.io.use

class MypropertyViewModel(app: Application) : AndroidViewModel(app) {

    private val context = app.applicationContext
    private val mypropertyDao = MypropertyDatabase.getDatabase(app).mypropertyDao()

    val allMypropertys: LiveData<List<Myproperty>> = mypropertyDao.getAllMypropertys()

    fun addMyproperty(name: String, price: Double, phone: String, imageUri: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val savedImagePath = saveImageToInternalStorage(Uri.parse(imageUri))
            val newMyproperty = Myproperty(
                name = name,
                price = price,
                phone = phone,
                imagePath = savedImagePath // use saved image path
            )
            mypropertyDao.insertMyproperty(newMyproperty)
        }
    }

    fun updateMyproperty(updatedMyproperty: Myproperty) {
        viewModelScope.launch(Dispatchers.IO) {
            mypropertyDao.updateMyproperty(updatedMyproperty)
        }
    }

    fun deleteMyproperty(myproperty: Myproperty) {
        viewModelScope.launch(Dispatchers.IO) {
            // Delete image from storage
            deleteImageFromInternalStorage(myproperty.imagePath)
            mypropertyDao.deleteMyproperty(myproperty)
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
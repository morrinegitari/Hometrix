package com.morrine.hometrix.repository

import android.content.Context
import com.morrine.hometrix.data.BedsitterDatabase
import com.morrine.hometrix.model.Bedsitter

class BedsitterRepository(context: Context) {
    private val bedsitterDao = BedsitterDatabase.getDatabase(context).bedsitterDao()

    suspend fun insertBedsitter(bedsitter: Bedsitter) {
        bedsitterDao.insertBedsitter(bedsitter)
    }

    fun getAllBedsitter() = bedsitterDao.getAllBedsitter()

    suspend fun deleteBedsitter(bedsitter: Bedsitter) = bedsitterDao.deleteBedsitter(bedsitter)
}


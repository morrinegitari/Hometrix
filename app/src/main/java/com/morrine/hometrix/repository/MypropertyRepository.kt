package com.morrine.hometrix.repository



import android.content.Context
import com.morrine.hometrix.data.MypropertyDatabase
import com.morrine.hometrix.model.Myproperty


class MypropertyRepository(context: Context) {
    private val mypropertyDao = MypropertyDatabase.getDatabase(context).mypropertyDao()

    suspend fun insertMyproperty(myproperty: Myproperty) {
        mypropertyDao.insertMyproperty(myproperty)
    }

    fun getAllMypropertys() = mypropertyDao.getAllMypropertys()

    suspend fun deleteMyproperty(myproperty: Myproperty) = mypropertyDao.deleteMyproperty(myproperty)
}


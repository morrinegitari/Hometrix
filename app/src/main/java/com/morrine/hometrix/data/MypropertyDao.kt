package com.morrine.iceberry.data


import androidx.lifecycle.LiveData
import androidx.room.*
import com.morrine.hometrix.model.Myproperty
import kotlinx.coroutines.flow.Flow

@Dao
interface MypropertyDao {
    @Query("SELECT * FROM mypropertys")
    fun getAllMypropertys(): LiveData<List<Myproperty>>

    @Insert
    suspend fun insertMyproperty(myproperty: Myproperty)

    @Update
    suspend fun updateMyproperty(myproperty: Myproperty)

    @Delete
    suspend fun deleteMyproperty(myproperty: Myproperty)
}

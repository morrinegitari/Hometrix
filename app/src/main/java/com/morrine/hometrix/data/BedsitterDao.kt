package com.morrine.hometrix.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.morrine.hometrix.model.Bedsitter
import kotlinx.coroutines.flow.Flow

@Dao
interface BedsitterDao {
    @Query("SELECT * FROM bedsitter")
    fun getAllBedsitter(): LiveData<List<Bedsitter>>

    @Insert
    suspend fun insertBedsitter(bedsitter: Bedsitter)

    @Update
    suspend fun updateBedsitter(bedsitter: Bedsitter)

    @Delete
    suspend fun deleteBedsitter(bedsitter: Bedsitter)
}

package com.example.penghitungkalori.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.penghitungkalori.model.AplikasiKalori

@Dao
interface AplikasiKaloriDao {
    @Query("SELECT * FROM AplikasiKalori")
    fun loadAll(): LiveData<List<AplikasiKalori>>

    @Query("SELECT * FROM AplikasiKalori WHERE id = :id")
    fun find(id: String): AplikasiKalori?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: AplikasiKalori)
    @Delete
    fun delete(item: AplikasiKalori)
}
package com.example.penghitungkalori.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.penghitungkalori.model.AplikasiKalori

@Database(entities = [AplikasiKalori::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun AplikasiKaloriDao(): AplikasiKaloriDao
}
package com.example.penghitungkalori.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AplikasiKalori(
    @PrimaryKey val id: String,
    val nama: String,
    val beratbadan: String,
    val tinggibadan: String,
    val umur: String,
)
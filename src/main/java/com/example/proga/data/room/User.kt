package com.example.proga.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @PrimaryKey(autoGenerate = true)val uid : Int = 0,
    @ColumnInfo(name = "name") val name : String?,
    ) {
}
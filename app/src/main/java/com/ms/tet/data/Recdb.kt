package com.ms.tet.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ms.tet.data.entities.RecEntity

@Database(entities = [RecEntity::class], version = 1)
abstract class Recdb : RoomDatabase(){
    abstract fun dao() : RecDao
}
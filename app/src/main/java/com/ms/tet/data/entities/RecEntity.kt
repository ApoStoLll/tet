package com.ms.tet.data.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "db")
data class RecEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var id : Int? = null,

    @ColumnInfo(name = "score")
    var scoreS : String,

    @ColumnInfo(name = "time")
    var times : String
)
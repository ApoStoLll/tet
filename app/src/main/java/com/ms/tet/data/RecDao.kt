package com.ms.tet.data

import androidx.room.*
import com.ms.tet.data.entities.RecEntity

@Dao
interface RecDao{
    @Query("SELECT * FROM db")
    fun getAll() : List<RecEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRec(rec: RecEntity)

}

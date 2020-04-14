package com.example.recyclerviewtestwitharchitecturemvvm.Utils.Room

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.recyclerviewtestwitharchitecturemvvm.Model.RecyclerViewModel

interface RecyclerViewModelDAO {

    @Query("SELECT * FROM testModel")
    fun getAll(): LiveData<List<RecyclerViewModel>>

    @Insert(onConflict = REPLACE)
    fun insertModel(recyclerViewModel: RecyclerViewModel)

    @Delete
    fun deleteModel(recyclerViewModel: RecyclerViewModel)
}

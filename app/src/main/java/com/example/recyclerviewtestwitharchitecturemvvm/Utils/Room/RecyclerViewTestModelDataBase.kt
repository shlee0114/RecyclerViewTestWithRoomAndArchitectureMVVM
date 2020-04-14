package com.example.recyclerviewtestwitharchitecturemvvm.Utils.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recyclerviewtestwitharchitecturemvvm.Model.RecyclerViewModel

@Database(entities = [RecyclerViewModel::class], version = 1)
abstract class RecyclerViewTestModelDataBase:RoomDatabase() {
    abstract fun modelDAO() : RecyclerViewModelDAO

    companion object{
        private var INSTANCE: RecyclerViewTestModelDataBase? = null

        fun getInstance(context: Context):RecyclerViewTestModelDataBase?{
            if(INSTANCE == null) {
                synchronized(RecyclerViewTestModelDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        RecyclerViewTestModelDataBase::class.java, "testModel")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}
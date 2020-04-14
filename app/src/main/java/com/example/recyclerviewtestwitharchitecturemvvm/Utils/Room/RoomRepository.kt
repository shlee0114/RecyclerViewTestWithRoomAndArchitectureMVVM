package com.example.recyclerviewtestwitharchitecturemvvm.Utils.Room

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.recyclerviewtestwitharchitecturemvvm.Model.RecyclerViewModel
import java.lang.Exception

class RoomRepository(application: Application){

    private val testDatabase : RecyclerViewTestModelDataBase  = RecyclerViewTestModelDataBase.getInstance(application)!!
    private val testDAO : RecyclerViewModelDAO = testDatabase.modelDAO()
    private val tests : LiveData<List<RecyclerViewModel>> = testDAO.getAll()

    fun getAll() = tests

    fun insert(recyclerViewModel: RecyclerViewModel){
        try{
            val thread = Thread(Runnable {
                testDAO.insertModel(recyclerViewModel)
            })
            thread.start()
        }catch (e : Exception){ }
    }

    fun delete(recyclerViewModel: RecyclerViewModel){
        try{
            val thread = Thread(Runnable {
                testDAO.deleteModel(recyclerViewModel)
            })
            thread.start()
        }catch (e : Exception){ }
    }
}
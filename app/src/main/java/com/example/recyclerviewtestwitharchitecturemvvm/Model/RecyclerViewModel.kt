package com.example.recyclerviewtestwitharchitecturemvvm.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "testModel")
data class RecyclerViewModel (

    @PrimaryKey(autoGenerate = true)
    var id : Int?,

    @ColumnInfo(name = "test")
    var test : String,

    @ColumnInfo(name = "test2")
    var test2 : String
){
    constructor() : this(null, "test2", "test3")
}
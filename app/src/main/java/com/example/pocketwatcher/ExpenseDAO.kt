package com.example.pocketwatcher

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDAO {
    @Query("SELECT * FROM expense_table")
    fun getAll(): Flow<List<ExpenseEntity>>

    @Insert
    fun insertAll(expenses: List<ExpenseEntity>)

    @Insert
    fun insert(expense: ExpenseEntity)

    @Query ("DELETE FROM expense_table")
    fun delete(expense: ExpenseEntity)

    @Query("DELETE FROM expense_table")
    fun deleteAll()
}


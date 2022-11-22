package com.example.pocketwatcher

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class MainViewModel(application: Application) : AndroidViewModel(application){
    private val expenseDAO: ExpenseDAO = AppDatabase.getInstance(getApplication<Application>().applicationContext).expenseDao()
    public val expenselist: LiveData<List<ExpenseEntity>> = expenseDAO.getAll()
    public suspend fun addexpense(expense:ExpenseEntity){expenseDAO.insert(expense)}
}
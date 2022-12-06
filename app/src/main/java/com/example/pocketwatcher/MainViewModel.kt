package com.example.pocketwatcher

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class MainViewModel(application: Application) : AndroidViewModel(application){
    private val expenseDAO: ExpenseDAO = AppDatabase.getInstance(getApplication<Application>().applicationContext).expenseDao()
    val expenselist: LiveData<List<ExpenseEntity>> = expenseDAO.getAll()
    fun addexpense(expense:ExpenseEntity){expenseDAO.insert(expense)}
}
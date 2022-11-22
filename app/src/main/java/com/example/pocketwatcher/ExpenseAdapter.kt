package com.example.pocketwatcher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpenseAdapter(private val listofexpenses:List<ExpenseEntity>):RecyclerView.Adapter<ExpenseAdapter.ViewHolder>() {
    class ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){
    val expensename: TextView = ItemView.findViewById(R.id.expensename)
        val expenseprice: TextView = ItemView.findViewById(R.id.expenseprice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.expense_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val expense = listofexpenses[position]
        holder.expensename.setText(expense.name)
        holder.expenseprice.setText(expense.price.toString())
    }

    override fun getItemCount(): Int {
        return listofexpenses.size
    }
}
package com.example.pocketwatcher

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OVExpenseAdapter(private val listofexpenses:List<ExpenseEntity>):RecyclerView.Adapter<OVExpenseAdapter.ViewHolder>() {
    class ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){
    val expensename: TextView = ItemView.findViewById(R.id.expensename)
        val expenseprice: TextView = ItemView.findViewById(R.id.expenseprice)
        val button: Button = ItemView.findViewById(R.id.payedbutton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.overview_expense_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val expense = listofexpenses[position]
        holder.expensename.setText(expense.name)
        holder.expenseprice.setText(expense.price.toString())
        if (expense.paid == true){
            holder.button.setBackgroundColor(Color.GREEN)
            holder.button.text = "PAYED"
        }
        holder.button.setOnClickListener {
            expense.paid = true
            holder.button.setBackgroundColor(Color.GREEN)
            holder.button.text = "PAYED"
        }
    }

    override fun getItemCount(): Int {
        return listofexpenses.size
    }
}
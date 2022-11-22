package com.example.pocketwatcher

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.launch

class TransactionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transactions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        val recyclerView = view.findViewById<RecyclerView>(R.id.Transactions)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.expenselist.observe(viewLifecycleOwner, Observer {
        recyclerView.adapter = ExpenseAdapter(it)
        })
        val namefield = view.findViewById<TextView>(R.id.editTextTextPersonName3)
        val pricefield = view.findViewById<TextView>(R.id.editTextTextPersonName4)
        view.findViewById<Button>(R.id.button).setOnClickListener(View.OnClickListener {
            val expense = ExpenseEntity(name = namefield.text.toString(), price = pricefield.text.toString().toInt())
            GlobalScope.launch(Dispatchers.IO){viewModel.addexpense(expense)}
        })
        val goalprice = view.findViewById<TextView>(R.id.balanceamount)
        val preferences:SharedPreferences = requireActivity().getSharedPreferences("Pref", Context.MODE_PRIVATE)
        goalprice.text = "$" + preferences.getInt("balance", -1).toString()
    }
    companion object {
        fun newInstance(): TransactionsFragment {
            return TransactionsFragment()
        }
    }
}
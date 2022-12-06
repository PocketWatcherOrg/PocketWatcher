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

class OverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        val recyclerView = view.findViewById<RecyclerView>(R.id.overviewrv)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.expenselist.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = OVExpenseAdapter(it)
        })
        val goalprice = view.findViewById<TextView>(R.id.goalabalanceov)
        val paidbalance = view.findViewById<TextView>(R.id.cpb)
        val balanceaway = view.findViewById<TextView>(R.id.balanceaway)
        val preferences: SharedPreferences = requireActivity().getSharedPreferences("Pref", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        goalprice.text = preferences.getInt("balance",0).toString()
        paidbalance.text = preferences.getInt("pb",0).toString()
        balanceaway.text = (preferences.getInt("balance",0) - preferences.getInt("pb",0)).toString()


    }

}

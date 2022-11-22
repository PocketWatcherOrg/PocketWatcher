package com.example.pocketwatcher

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var BottomNav: BottomNavigationView
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BottomNav = findViewById(R.id.BottomNav)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        supportFragmentManager.beginTransaction().replace(R.id.Frame, OverviewFragment()).commit()
        BottomNav.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {
            lateinit var selectedfragement:Fragment
            when(it.itemId){
                R.id.Overview->{
                    selectedfragement = OverviewFragment()
                }
                R.id.Transactions->{
                    selectedfragement = TransactionsFragment()
                }
            }
            supportFragmentManager.beginTransaction().replace(R.id.Frame, selectedfragement).commit()
            true
        })
    }
}

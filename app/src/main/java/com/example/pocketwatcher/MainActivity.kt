package com.example.pocketwatcher

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView


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

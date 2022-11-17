package com.example.pocketwatcher

import android.app.Application

class PocketWatcherApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}


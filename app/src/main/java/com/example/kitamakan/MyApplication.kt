package com.example.kitamakan

import android.annotation.SuppressLint
import android.app.Application
import com.example.kitamakan.data.local.PreferenceManager
import com.readystatesoftware.chuck.ChuckInterceptor

class MyApplication : Application() {

    // Buat companion object untuk menyimpan variabel ata fungsi yang akan di set secara global
    companion object {
        lateinit var preferenceManager: PreferenceManager // untuk local data

        @SuppressLint("StaticFieldLeak")
        lateinit var chuckInterceptor: ChuckInterceptor // untuk debug di device
    }

    override fun onCreate() {
        super.onCreate()
        preferenceManager = PreferenceManager(this)
        chuckInterceptor = ChuckInterceptor(this)
    }
}
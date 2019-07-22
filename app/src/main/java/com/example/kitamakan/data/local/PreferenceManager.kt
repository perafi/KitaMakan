package com.example.kitamakan.data.local

import android.content.Context
import com.example.kitamakan.data.model.login.LoginData
import com.google.gson.Gson

class PreferenceManager(context : Context) {

    // INISIALISASI NAMA PREFERENCE
    val PREF_NAME = "kitamakan_pref"

    // INISIALISASI KATA KUNCI DI PREFERENCE
    val KEY_IS_USER_LOGIN = "is_user_login"
    val KEY_LOGIN_DATA = "login_data"

    // BUAT PREFERENCE
    val mPreference = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    // BUAT EDITOR UNTUK MEMANGGIL METHOD PREFERENCE
    val mEditor = mPreference.edit()

    //INISIALISASI GSON UNTUK MERUBAH JSON MENJADI STRING DAN SEBALIKNYA
    val gson = Gson()

    // FUNCTION UNTUK MENYIMPAN DATA KETIKA LOGIN SUKSES
    fun successLogin(loginData : LoginData){
        mEditor.putBoolean(KEY_IS_USER_LOGIN, true)
        mEditor.putString(KEY_LOGIN_DATA, gson.toJson(loginData))
        mEditor.commit()
    }

    // PROCEDURE UNTUK MENDAPATKAN VALUE APAKAH USER SUDAH LOGIN ATAU BELUM JIKA SUDAH "TRUE", JIKA BELUM "FALSE"
    fun isUserLogin() : Boolean {
        return mPreference.getBoolean(KEY_IS_USER_LOGIN, false)
    }

    // PROCEDURE UNTUK MENDAPATKAN DATA LOGIN JIKA ADA MAKA KELUARKAN DATA JIKA TIDAK MAKA NULL
    fun getLoginData() : LoginData? {
        val sLoginData = mPreference.getString(KEY_LOGIN_DATA, null)
        if(sLoginData != null){
            return gson.fromJson(sLoginData, LoginData::class.java)
        }
        return null
    }

    // HAPUS SEMUA DATA YANG TERSIMPAN DI SHARED PREFERANCE
    fun clearData() {
        mEditor.clear().commit()
    }
}
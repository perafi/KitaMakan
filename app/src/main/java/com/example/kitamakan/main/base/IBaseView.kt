package com.example.kitamakan.main.base

import android.content.Context

interface IBaseView {

    fun getContext() : Context

    fun showError(error : String?)

    fun showMessage(message : String?)

    fun onUnauthorized()
}
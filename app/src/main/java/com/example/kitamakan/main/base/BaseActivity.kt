package com.example.kitamakan.main.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
abstract class BaseActivity<in V: IBaseView, T: IBasePresenter<V>> : AppCompatActivity(), IBaseView {

    protected abstract var mPresenter : T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attachView(this as V)
    }

    override fun getContext(): Context = this

    override fun showError(error: String?) {
        Toast.makeText(this, error,Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(message: String?) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.dettachView()
    }
}
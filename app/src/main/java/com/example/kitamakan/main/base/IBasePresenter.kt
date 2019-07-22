package com.example.kitamakan.main.base

interface IBasePresenter<in V : IBaseView> {

    fun attachView(view: V)

    fun dettachView()
}
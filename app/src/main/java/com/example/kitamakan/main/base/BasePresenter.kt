package com.example.kitamakan.main.base

open class BasePresenter<V : IBaseView> : IBasePresenter<V> {

    protected var mView : V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun dettachView() {
        mView = null
    }
}
package com.example.kitamakan.service

import com.example.kitamakan.data.model.login.LoginRequest
import com.example.kitamakan.data.model.login.LoginResponse
import com.example.kitamakan.data.model.transaction.TransactionResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import rx.Observable

interface ApiInterface {

    @POST("login")
    fun login(@Body loginRequest: LoginRequest) : Observable<LoginResponse>

    @GET("transaction")
    fun getTransaction() : Observable<TransactionResponse>
}
package com.example.kitamakan.main.features.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.kitamakan.*
import com.example.kitamakan.data.model.login.LoginData
import com.example.kitamakan.data.model.login.LoginRequest
import com.example.kitamakan.main.features.main.MainActivity
import com.example.kitamakan.main.features.register.RegisterActivity
import com.example.kitamakan.service.ApiClient
import kotlinx.android.synthetic.main.activity_login.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class LoginActivity : AppCompatActivity() {

    val preferenceManager = MyApplication.preferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            login()
        }

        btn_to_register.setOnClickListener {
            goToRegister()
        }
    }

    fun login(){

        if(isFormValid()){
            val loginRequest = LoginRequest()
            loginRequest.username = et_key_login.text.toString()
            loginRequest.password = et_password.text.toString()

            ApiClient.getClient().login(loginRequest)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    onLoginSuccess(response.data!!)
                },{ error ->
                    onLoginFailed(error!!.message)
                })
        }else{
            onLoginFailed("Form harus dilengkapi")
        }

    }

    fun isFormValid() : Boolean {
        if(et_key_login.text.length == 0 || et_password.text.length == 0) return false
        return true
    }

    fun goToRegister(){
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    fun onLoginSuccess(loginData: LoginData){
        preferenceManager.successLogin(loginData)
        val intent = Intent(this, MainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun onLoginFailed(message : String?){
        if(message.isNullOrEmpty()){
            Toast.makeText(this, R.string.login_failed, Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}
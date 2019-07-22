package com.example.kitamakan.main.features.register

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.kitamakan.R
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.et_password

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            register()
        }

        btn_to_login.setOnClickListener {
            goToLogin()
        }
    }

    fun goToLogin(){
        finish()
    }

    fun register(){
        if(isFormValid()){
            Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    fun isFormValid() : Boolean {
        if(
            et_name.text.length == 0
            || et_address.text.length == 0
            || et_username.text.length == 0
            || et_email.text.length == 0
            || et_phonenumber.text.length == 0
            || et_password.text.length == 0
            || et_confirm_password.text.length == 0
        ){
            Toast.makeText(this, "Please complete form", Toast.LENGTH_SHORT).show()
            return false
        }

        if(et_confirm_password.text.toString() != et_password.text.toString()){
            Toast.makeText(this, "You dont remember password, please check", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
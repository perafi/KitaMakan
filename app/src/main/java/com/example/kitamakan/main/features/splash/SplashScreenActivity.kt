package com.example.kitamakan.main.features.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.kitamakan.MyApplication
import com.example.kitamakan.R
import com.example.kitamakan.main.features.login.LoginActivity
import com.example.kitamakan.main.features.main.MainActivity

class SplashScreenActivity : AppCompatActivity() {

    val preferenceManager = MyApplication.preferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({
            if(preferenceManager.isUserLogin()){
                goToMainActivity()
            }else{
                goToLoginActivity()
            }
        }, 3000)
    }

    fun goToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun goToLoginActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
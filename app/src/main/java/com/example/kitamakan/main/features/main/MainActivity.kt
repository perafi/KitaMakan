package com.example.kitamakan.main.features.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import com.example.kitamakan.R
import com.example.kitamakan.main.features.main.home.HomeFragment
import com.example.kitamakan.main.features.main.notification.NotificationFragment
import com.example.kitamakan.main.features.main.order.OrderFragment
import com.example.kitamakan.main.features.main.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialFragment()
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

    fun initialFragment(){
        val fragment = HomeFragment.newInstance()
        openFragment(fragment)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                val homeFragment = HomeFragment.newInstance()
                openFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.order -> {
                val orderFragment = OrderFragment.newInstance()
                openFragment(orderFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.notification -> {
                val notificationFragment = NotificationFragment.newInstance()
                openFragment(notificationFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                val profileFragment = ProfileFragment.newInstance()
                openFragment(profileFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}

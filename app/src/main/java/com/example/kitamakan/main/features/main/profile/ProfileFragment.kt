package com.example.kitamakan.main.features.main.profile

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kitamakan.MyApplication
import com.example.kitamakan.R
import com.example.kitamakan.main.features.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    val preferenceManager = MyApplication.preferenceManager

    // Buat fungsi untuk pemanggilan Class Fragment
    companion object {
        fun newInstance() : ProfileFragment =
            ProfileFragment()
    }

    // Ketika halaman pertama kali dibuka, Class mencoba untuk membaca layout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    // Ketika layout sudah terbaca
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataLogin = preferenceManager.getLoginData()
        Glide.with(activity!!).load(dataLogin!!.profileImage).centerCrop().into(profile_image)
        tv_hallo_name.setText("Hallo " + dataLogin.fullname)
        btn_logout.setOnClickListener {
            logout()
        }
    }

    fun logout(){
        preferenceManager.clearData()
        val intent = Intent(activity, LoginActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
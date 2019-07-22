package com.example.kitamakan.main.features.main.order.process

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kitamakan.R

class OrderProcessFragment : Fragment() {

    // Buat fungsi untuk pemanggilan Class Fragment
    companion object {
        fun newInstance() : OrderProcessFragment =
            OrderProcessFragment()
    }

    // Ketika halaman pertama kali dibuka, Class mencoba untuk membaca layout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_order_process, container, false)
    }

    // Ketika layout sudah terbaca
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
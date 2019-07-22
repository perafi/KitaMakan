package com.example.kitamakan.main.features.main.order

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kitamakan.R
import com.example.kitamakan.main.features.main.order.history.OrderHistoryFragment
import com.example.kitamakan.main.features.main.order.process.OrderProcessFragment
import kotlinx.android.synthetic.main.fragment_order.*

class OrderFragment : Fragment() {

    // Buat fungsi untuk pemanggilan Class Fragment
    companion object {
        fun newInstance() : OrderFragment =
            OrderFragment()
    }

    // Ketika halaman pertama kali dibuka, Class mencoba untuk membaca layout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    // Ketika layout sudah terbaca
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view_pager.adapter = ViewPagerAdapter(childFragmentManager)
        tab_layout.setupWithViewPager(view_pager)
    }

    inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

        // sebuah list yang menampung objek Fragment
        private val pages : List<Fragment> = listOf(
            OrderProcessFragment.newInstance(),
            OrderHistoryFragment.newInstance()
        )

        // menentukan fragment yang akan dibuka pada posisi tertentu
        override fun getItem(position: Int): Fragment {
            return pages[position]
        }

        override fun getCount(): Int {
            return pages.size
        }

        // judul untuk tabs
        override fun getPageTitle(position: Int): CharSequence? {
            return when(position){
                0 -> "Process"
                else -> "History"
            }
        }
    }
}
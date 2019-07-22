package com.example.kitamakan.main.features.main.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kitamakan.data.dataadapter.Menu
import com.example.kitamakan.R
import com.example.kitamakan.main.features.main.adapter.MenuAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    var menu = ArrayList<Menu>()

    // Buat fungsi untuk pemanggilan Class Fragment
    companion object {
        fun newInstance() : HomeFragment =
            HomeFragment()
    }

    // Ketika halaman pertama kali dibuka, Class mencoba untuk membaca layout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // Ketika layout sudah terbaca
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        menu = arrayListOf()
        menu.add(
            Menu(
                1,
                "https://cdn1.iconfinder.com/data/icons/rounded-black-basic-ui/139/Minimize-RoundedBlack-512.png",
                "Menu 1"
            )
        )
        menu.add(
            Menu(
                2,
                "https://cdn1.iconfinder.com/data/icons/rounded-black-basic-ui/139/Minimize-RoundedBlack-512.png",
                "Menu 2"
            )
        )
        menu.add(
            Menu(
                3,
                "https://cdn1.iconfinder.com/data/icons/rounded-black-basic-ui/139/Minimize-RoundedBlack-512.png",
                "Menu 3"
            )
        )
        menu.add(
            Menu(
                4,
                "https://cdn1.iconfinder.com/data/icons/rounded-black-basic-ui/139/Minimize-RoundedBlack-512.png",
                "Menu 4"
            )
        )
        menu.add(
            Menu(
                5,
                "https://cdn1.iconfinder.com/data/icons/rounded-black-basic-ui/139/Minimize-RoundedBlack-512.png",
                "Menu 5"
            )
        )
        menu.add(
            Menu(
                6,
                "https://cdn1.iconfinder.com/data/icons/rounded-black-basic-ui/139/Minimize-RoundedBlack-512.png",
                "Menu 6"
            )
        )
        menu.add(
            Menu(
                7,
                "https://cdn1.iconfinder.com/data/icons/rounded-black-basic-ui/139/Minimize-RoundedBlack-512.png",
                "Menu 7"
            )
        )
        menu.add(
            Menu(
                8,
                "https://cdn1.iconfinder.com/data/icons/rounded-black-basic-ui/139/Minimize-RoundedBlack-512.png",
                "Menu 8"
            )
        )

        gridView.adapter = MenuAdapter(activity!!, menu)
    }


}
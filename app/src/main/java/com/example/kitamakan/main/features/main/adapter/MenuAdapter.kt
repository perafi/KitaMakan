package com.example.kitamakan.main.features.main.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.kitamakan.data.dataadapter.Menu
import com.example.kitamakan.R
import kotlinx.android.synthetic.main.item_menu.view.*

class MenuAdapter(context: Context, var listData: ArrayList<Menu>) : BaseAdapter() {

    var context: Context? = context

    override fun getCount(): Int {
        return listData.size
    }

    override fun getItem(position: Int): Any {
        return listData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val data = this.listData[position]

        val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val viewLayout = inflator.inflate(R.layout.item_menu, null)

        Glide.with(context!!).load(data.image).into(viewLayout.item_image)

        viewLayout.item_text.text = data.title
        viewLayout.setOnClickListener {
            Toast.makeText(context, "Ini adalah menu "+data.title, Toast.LENGTH_SHORT).show()
        }

        return viewLayout
    }
}
package com.example.kitamakan.main.features.main.order.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kitamakan.data.dataadapter.OrderHistory
import com.example.kitamakan.R
import kotlinx.android.synthetic.main.item_order_history.view.*

class OrderHistoryAdapter(val context: Context, val list: List<OrderHistory>) : RecyclerView.Adapter<OrderHistoryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_order_history, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list.get(position)

        Glide.with(context).load(data.image).into(holder.image)
        holder.textInfo.text = data.info
        holder.textDate.text = data.date
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image = view.item_image
        var textInfo = view.item_text_info
        var textDate = view.item_text_tanggal
    }
}
package com.example.kitamakan.main.features.main.order.history

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kitamakan.data.dataadapter.OrderHistory
import com.example.kitamakan.R
import com.example.kitamakan.data.model.transaction.TransactionDataItem
import com.example.kitamakan.main.features.main.order.adapter.OrderHistoryAdapter
import com.example.kitamakan.service.ApiClient
import kotlinx.android.synthetic.main.fragment_order_history.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class OrderHistoryFragment : Fragment() {

    var listData = ArrayList<OrderHistory>()

    // Buat fungsi untuk pemanggilan Class Fragment
    companion object {
        fun newInstance() : OrderHistoryFragment =
            OrderHistoryFragment()
    }

    // Ketika halaman pertama kali dibuka, Class mencoba untuk membaca layout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_order_history, container, false)
    }

    // Ketika layout sudah terbaca
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getTransaction()
    }

    fun getTransaction(){
        ApiClient.getClient().getTransaction()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                onGetTransactionSuccess(response.data!!.data!!)
            },{ error ->
                onGetTransactionFailed()
            })
    }

    fun onGetTransactionSuccess(listTransactionDataItem: List<TransactionDataItem>){
        Toast.makeText(activity!!, "Berhasil mengambil data", Toast.LENGTH_SHORT).show()

        listData = arrayListOf()
        for(i in 0 until listTransactionDataItem.size){
            listData.add(
                OrderHistory(
                    listTransactionDataItem[i].id,
                    listTransactionDataItem[i].date,
                    listTransactionDataItem[i].image,
                    listTransactionDataItem[i].info
                )
            )
        }

        recycler_order_history.layoutManager = LinearLayoutManager(activity!!)
        recycler_order_history.adapter =
            OrderHistoryAdapter(activity!!, listData)
    }

    fun onGetTransactionFailed(){
        Toast.makeText(activity!!, "Gagal mengambil data", Toast.LENGTH_SHORT).show()
    }
}
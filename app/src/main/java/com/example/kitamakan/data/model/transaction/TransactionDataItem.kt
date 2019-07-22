package com.example.kitamakan.data.model.transaction

import com.google.gson.annotations.SerializedName

class TransactionDataItem {

    @SerializedName("id")
    var id : Int? = null

    @SerializedName("tanggal")
    var date : String? = null

    @SerializedName("image")
    var image : String? = null


    @SerializedName("info")
    var info : String? = null

    get() = field
    set(value) {field = value}

}
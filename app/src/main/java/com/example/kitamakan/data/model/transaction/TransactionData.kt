package com.example.kitamakan.data.model.transaction

import com.google.gson.annotations.SerializedName

class TransactionData {

    @SerializedName("tipe")
    var type : String? = null

    @SerializedName("data")
    var data : List<TransactionDataItem>? = null

    get() = field
    set(value) {field = value}
}
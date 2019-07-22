package com.example.kitamakan.data.model.transaction

import com.example.kitamakan.data.model.Meta
import com.google.gson.annotations.SerializedName

class TransactionResponse {

    @SerializedName("meta")
    var meta : Meta? = null

    @SerializedName("data")
    var data : TransactionData? = null

    get() = field
    set(value) {field = value}
}
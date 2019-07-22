package com.example.kitamakan.data.model

import com.google.gson.annotations.SerializedName

class Meta {

    @SerializedName("code")
    var code : Int? = null

    @SerializedName("message")
    var message : String? = null

    get() = field
    set(value) {field = value}

}
package com.example.kitamakan.data.model.login

import com.google.gson.annotations.SerializedName

class LoginRequest {

    @SerializedName("username")
    var username : String? = null

    @SerializedName("password")
    var password : String? = null

    get() = field
    set(value) {field = value}
}
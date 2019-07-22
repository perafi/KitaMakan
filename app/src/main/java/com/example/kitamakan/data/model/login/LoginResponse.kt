package com.example.kitamakan.data.model.login

import com.example.kitamakan.data.model.Meta
import com.google.gson.annotations.SerializedName

class LoginResponse {

    @SerializedName("meta")
    var meta : Meta? = null

    @SerializedName("data")
    var data : LoginData? = null

    get() = field
    set(value) {field = value}
}
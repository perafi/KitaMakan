package com.example.kitamakan.data.model.login

import com.google.gson.annotations.SerializedName

class LoginData {

    @SerializedName("username")
    var username : String? = null

    @SerializedName("fullname")
    var fullname : String? = null

    @SerializedName("email")
    var email : String? = null

    @SerializedName("profile_image")
    var profileImage : String? = null

    get() = field
    set(value) {field = value}
}
package com.example.todo.login_reg.models

import android.net.Uri
import androidx.lifecycle.MutableLiveData

class UserInfo {
    // Normal variables
    var fullName: String = ""
    var gender: String = ""
    var password: String = ""
    var phone: String = ""
    var email: String = ""
    var profileUrl: Uri = Uri.EMPTY

}
package com.example.netflix

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
     var firstName  = MutableLiveData("")
     var lastName =  MutableLiveData("")
     var email =  MutableLiveData("")
     var phoneNumber =  MutableLiveData("Null")
     var userName =  MutableLiveData("Null")
      var imageProfile : Uri? = null

    fun setFirstName(input: String) {
        firstName.value = input
    }

    fun setLastName(input: String) {
        lastName.value = input
    }

    fun setEmail(input: String) {
        email.value = input
    }

    fun setPhoneNumber(input: String) {
        phoneNumber.value = input
    }

    fun setUserName(input: String) {
        userName.value = input
    }
    fun setProfile(url: Uri?){
        imageProfile = url
    }

    fun checkRegister(): Boolean {
        if (firstName.value != "" && lastName.value != "" && email.value != "" && imageProfile != null) {
            return true
        }
        return false
    }
}
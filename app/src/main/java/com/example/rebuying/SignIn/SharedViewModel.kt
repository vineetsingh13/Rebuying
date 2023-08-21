package com.example.rebuying.SignIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {

    private var _email= MutableLiveData<String>()
    val email: LiveData<String> = _email
    fun setEmail(newemail:String){
        _email.value=newemail
    }

    private var _password=MutableLiveData<String>()
    val password: LiveData<String> = _password
    fun setPassword(newPassword:String){
        _password.value=newPassword
    }

    private var _phone=MutableLiveData<String>()
    val phone:LiveData<String> = _phone
    fun setPhone(newPhone: String){
        _phone.value=newPhone
    }

    private var _orgName=MutableLiveData<String>()
    val orgName:LiveData<String> = _orgName
    fun setOrgName(newName:String){
        _orgName.value=newName
    }

    private var _cin=MutableLiveData<String>()
    val cin:LiveData<String> = _cin
    fun setCIN(newCIN: String){
        _cin.value=newCIN
    }

    private var _signatoryName=MutableLiveData<String>()
    val signatoryName:LiveData<String> = _signatoryName
    fun setsignatoryName(newsignatoryName: String){
        _signatoryName.value=newsignatoryName
    }

    private var _BusinessNature=MutableLiveData<String>()
    val BusinessNature:LiveData<String> = _BusinessNature
    fun setBusinessNature(newBusinessNature: String){
        _BusinessNature.value=newBusinessNature
    }

    private var _address=MutableLiveData<String>()
    val address:LiveData<String> = _address
    fun setaddress(newaddress: String){
        _address.value=newaddress
    }

    private var _GST=MutableLiveData<String>()
    val GST:LiveData<String> = _GST
    fun setGST(newGST: String){
        _GST.value=newGST
    }

}
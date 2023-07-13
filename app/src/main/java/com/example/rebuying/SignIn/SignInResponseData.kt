package com.example.rebuying.SignIn

import com.google.gson.annotations.SerializedName

data class SignInResponseData(

    @SerializedName("UserId")
    val UserId:Int,

    @SerializedName("NameOfOrgranization")
    val NameOfOrgasation:String,

    @SerializedName("EmailID")
    val email_id:String,

    @SerializedName("Address")
    val address:String,

    @SerializedName("GST")
    val GST: String,

    @SerializedName("AuthorisedSignatoryName")
    val signatory_name:String,

    @SerializedName("ContactNumber")
    val contact_number:String,

    @SerializedName("BusinessType")
    val business_type:String,

    @SerializedName("Password")
    val password:String

)

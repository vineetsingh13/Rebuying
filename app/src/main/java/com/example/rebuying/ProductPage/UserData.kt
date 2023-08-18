package com.example.rebuying.ProductPage

import com.google.gson.annotations.SerializedName

data class UserData(

    @SerializedName("UserId")
    val userId: Int,

    @SerializedName("NameOfOrgranization")
    val nameOfOrganization: String,

    @SerializedName("EmailID")
    val emailId: String,

    @SerializedName("Address")
    val address: String,

    @SerializedName("GST")
    val gst: String,

    @SerializedName("AuthorisedSignatoryName")
    val authorisedSignatoryName: String,

    @SerializedName("ContactNumber")
    val contactNumber: String,

    @SerializedName("BusinessType")
    val businessType: String,

    @SerializedName("Password")
    val password: String
)

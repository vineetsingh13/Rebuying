package com.example.rebuying.HomeFragment

import com.google.gson.annotations.SerializedName

data class MachineResponseData(

    @SerializedName("product_id")
    val productId: Int,

    @SerializedName("machine_type")
    val machineType: String,

    @SerializedName("name_of_machine")
    val nameOfMachine: String,

    @SerializedName("machine_manufacturer")
    val machineManufacturer: String,

    @SerializedName("machine_model_number")
    val machineModelNumber: String,

    @SerializedName("machine_build_date")
    val machineBuildDate: String,

    @SerializedName("machine_condition")
    val machineCondition: String,

    @SerializedName("machine_dimension")
    val machineDimension: String,

    @SerializedName("machine_weight")
    val machineWeight: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("selling_price")
    val sellingPrice: String,

    @SerializedName("location_of_machine")
    val locationOfMachine: String,

    @SerializedName("machine_image_1")
    val machineImage1: String,

    @SerializedName("machine_image_2")
    val machineImage2: String,

    @SerializedName("machine_image_3")
    val machineImage3: String,

    @SerializedName("machine_image_4")
    val machineImage4: String?,

    @SerializedName("UserId")
    val userId: Int

    )

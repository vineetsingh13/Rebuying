package com.example.rebuying.ProductPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.rebuying.R
import com.example.rebuying.ServiceGenerator
import com.example.rebuying.databinding.ActivityHomeBinding
import com.example.rebuying.databinding.ActivityProductPageBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Locale
import kotlin.system.measureTimeMillis

class ProductPage : AppCompatActivity() {

    private lateinit var binding: ActivityProductPageBinding
    private var id: Int = 0
    private lateinit var imageList: ArrayList<SlideModel>
    private lateinit var product_info: ProductResponseData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProductPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productId= intent.getIntExtra("productId",-1)
        id=productId

    }

    override fun onStart() {


        lifecycleScope.launch(Dispatchers.IO) {
            val time= measureTimeMillis {
                run {
                    api_response()
                }
            }
        }
        super.onStart()
    }

    private fun api_response() {

        val service=ServiceGenerator.buildService(ProductRetrofit::class.java)
        val call=service.getProduct(id)

        call.enqueue(object: Callback<ProductResponseData>{
            override fun onResponse(
                call: Call<ProductResponseData>,
                response: Response<ProductResponseData>
            ) {
                if (response.code()==200){
                    Log.e("Success",response.body().toString())
                    product_info= response.body()!!
                    val url="https://web-production-dae5.up.railway.app"
                    imageList= ArrayList()
                    imageList.add(SlideModel("$url${product_info.machineImage1}"))
                    imageList.add(SlideModel("$url${product_info.machineImage2}"))
                    imageList.add(SlideModel("$url${product_info.machineImage3}"))

                    binding.iamgeSlider.setImageList(imageList,ScaleTypes.FIT)
                    user_api_response(product_info.userId)

                    binding.productName.text= product_info.nameOfMachine.uppercase(Locale.getDefault())
                    binding.productDescription.text=product_info.description
                    binding.machineTypeValue.text=product_info.machineType
                    binding.machineManufacturerValue.text=product_info.machineManufacturer
                    binding.modelNumberValue.text=product_info.machineModelNumber
                    binding.machineBuildDateValue.text=product_info.machineBuildDate
                    binding.machineDimensionValue.text=product_info.machineDimension
                    binding.machineWeightValue.text=product_info.machineWeight
                    binding.machineConditionValue.text=product_info.machineCondition
                }
            }

            override fun onFailure(call: Call<ProductResponseData>, t: Throwable) {
                Toast.makeText(this@ProductPage,t.message,Toast.LENGTH_SHORT).show()
                Log.e("FAILURE", t.message.toString())
            }

        })
    }

    private fun user_api_response(id:Int){

        val service= ServiceGenerator.buildService(UserRetrofit::class.java)
        val call=service.getUserData(id)

        call.enqueue(object: Callback<UserData>{
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                if (response.code()==200){
                    Log.e("SUCCESS USER DATA",response.body().toString())
                    var user_info=response.body()
                    binding.companyName.text= user_info!!.nameOfOrganization
                }
            }

            override fun onFailure(call: Call<UserData>, t: Throwable) {
                Toast.makeText(this@ProductPage,t.message,Toast.LENGTH_SHORT).show()
            }

        })
    }
}
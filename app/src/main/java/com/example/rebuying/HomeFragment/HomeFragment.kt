package com.example.rebuying.HomeFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rebuying.R
import com.example.rebuying.ServiceGenerator
import com.example.rebuying.databinding.FragmentFirstSignInBinding
import com.example.rebuying.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.measureTimeMillis


class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding
    private lateinit var machineDataAdapter: MachineDataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onStart() {

        lifecycleScope.launch(Dispatchers.IO) {
            val time= measureTimeMillis {
                async {
                    api_response()
                }
            }
        }


        super.onStart()
    }

    private fun api_response() {

        val service= ServiceGenerator.buildService(MachineRetrofit::class.java)
        val call=service.getProducts()

        call.enqueue(object : Callback<MutableList<MachineResponseData>>{
            override fun onResponse(
                call: Call<MutableList<MachineResponseData>>,
                response: Response<MutableList<MachineResponseData>>
            ) {
                if (response.code()==200){
                    binding.HomeRecyclerView.layoutManager=LinearLayoutManager(context)
                    machineDataAdapter= MachineDataAdapter(response.body()!!)

                    binding.HomeRecyclerView.adapter=machineDataAdapter
                    Log.e("Success",response.body().toString())
                }
            }

            override fun onFailure(call: Call<MutableList<MachineResponseData>>, t: Throwable) {
                Toast.makeText(requireContext(),t.message,Toast.LENGTH_SHORT).show()
            }

        })
    }


}
package com.example.rebuying.HomeFragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rebuying.ProductPage.ProductPage
import com.example.rebuying.databinding.HomeCardViewBinding

class MachineDataAdapter(var machineData: MutableList<MachineResponseData>):
    RecyclerView.Adapter<MachineViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MachineViewHolder {

        val binding= HomeCardViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MachineViewHolder(binding)

    }

    override fun getItemCount(): Int {

        return machineData.size
    }

    override fun onBindViewHolder(holder: MachineViewHolder, position: Int) {

        val productId= machineData[position].productId
        holder.itemView.setOnClickListener {

            val intent=Intent(holder.itemView.context,ProductPage::class.java)
            intent.putExtra("productId",productId)

            holder.itemView.context.startActivity(intent)
        }

        return holder.bindView(machineData[position])
    }
}

class MachineViewHolder(val binding:HomeCardViewBinding): RecyclerView.ViewHolder(binding.root) {


    var image=binding.image
    var name_of_machine=binding.title
    var machine_location=binding.location

    fun bindView(machineData: MachineResponseData){

        //val url="http://10.0.2.2:8000"
        val url="https://web-production-dae5.up.railway.app"
        val full_url="$url${machineData.machineImage1}"
        Glide.with(binding.root.context).load(full_url).into(image)
        name_of_machine.text=machineData.nameOfMachine
        machine_location.text=machineData.locationOfMachine
    }
}

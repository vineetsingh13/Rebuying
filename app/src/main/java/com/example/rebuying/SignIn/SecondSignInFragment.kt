package com.example.rebuying.SignIn

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.rebuying.databinding.FragmentSecondSignInBinding

class SecondSignInFragment : Fragment() {

    private lateinit var binding: FragmentSecondSignInBinding

    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentSecondSignInBinding.inflate(inflater, container, false)

        /*binding.NameOfOrganisationInputText.setText(sharedViewModel.email.value.toString())
        binding.AdddressInputText.setText(sharedViewModel.password.value.toString())*/


        binding.NameOfOrganisationInputText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                val name=p0.toString()
                sharedViewModel.setOrgName(name)
            }

        })

        binding.CINInputText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                val cin=p0.toString()
                sharedViewModel.setCIN(cin)
            }
        })

        binding.SignatoryNameInputText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                val name=p0.toString()
                sharedViewModel.setsignatoryName(name)
            }

        })

        binding.BusinessTypeInputText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                val name=p0.toString()
                sharedViewModel.setBusinessNature(name)
            }
        })

        binding.AdddressInputText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                val name=p0.toString()
                sharedViewModel.setaddress(name)
            }

        })

        binding.GSTInputText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                if (p0.isNullOrEmpty()==true){
                    sharedViewModel.setGST("")
                }
                val name=p0.toString()
                sharedViewModel.setGST(name)
            }

        })

        return binding.root

    }


}
package com.example.rebuying.SignIn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.aceinteract.android.stepper.StepperNavigationView
import com.example.rebuying.HomeActivity
import com.example.rebuying.R
import com.example.rebuying.ServiceGenerator
import com.example.rebuying.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.measureTimeMillis

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

   private lateinit var sharedViewModel: SharedViewModel
   private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val stepper = findViewById<StepperNavigationView>(R.id.stepper)
        stepper.setupWithNavController(findNavController(R.id.frame_stepper))

        val shared_pref=getSharedPreferences("USER_ID_PREF", MODE_PRIVATE)
        val editor=shared_pref.edit()

        sharedViewModel=ViewModelProvider(this).get(SharedViewModel::class.java)

        auth=FirebaseAuth.getInstance()

        binding.nextButton.setOnClickListener {
            stepper.goToNextStep()
            binding.nextButton.visibility=View.GONE
            binding.finishButton.visibility=View.VISIBLE
        }

        binding.finishButton.setOnClickListener {

            lifecycleScope.launch(Dispatchers.IO) {
                val time= measureTimeMillis {
                    async {
                        val email=sharedViewModel.email.value.toString()
                        val name_org=sharedViewModel.orgName.value.toString()
                        val address=sharedViewModel.address.value.toString()
                        val gst=sharedViewModel.GST.value.toString()
                        val signatory_name=sharedViewModel.signatoryName.value.toString()
                        val phone=sharedViewModel.phone.value.toString()
                        val business_type=sharedViewModel.BusinessNature.value.toString()
                        val password=sharedViewModel.password.value.toString()

                        val body_data = SignInData(name_org,email,address,gst,signatory_name,phone,business_type,password)

                        val service=ServiceGenerator.buildService(SignInRetroft::class.java)

                        service.createUser(body_data).enqueue(object: Callback<SignInResponseData>{
                            override fun onResponse(
                                call: Call<SignInResponseData>,
                                response: Response<SignInResponseData>
                            ) {
                                if (response.code()==200){
                                    Log.e("SUCCESS",response.body().toString())

                                    editor.apply{
                                        putInt("UserId", response.body()!!.UserId)
                                        putString("Name_of_organisation", response.body()!!.NameOfOrgasation)
                                        apply()
                                    }

                                    signUp(response.body()!!.email_id,
                                        response.body()!!.password)


                                }
                            }

                            override fun onFailure(call: Call<SignInResponseData>, t: Throwable) {
                                Log.e("ERROR",t.message.toString())
                            }

                        })
                    }
                }
            }

        }

    }

    private fun signUp(email: String, password: String){

        //THE PASSWORD SHOULD BE ATLEAST SIX CHARACTERS
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(this@SignInActivity,"Login Successful",Toast.LENGTH_SHORT).show()
                    val i= Intent(this@SignInActivity, HomeActivity::class.java)
                    i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(i)
                    finish()

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this@SignInActivity,"some error occurred", Toast.LENGTH_SHORT).show()
                }
            }

    }
}
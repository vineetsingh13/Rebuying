package com.example.rebuying

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rebuying.SignIn.SignInActivity
import com.example.rebuying.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val shared_pref=getSharedPreferences("USER_ID_PREF", MODE_PRIVATE)
        val editor=shared_pref.edit()

        binding.LoginButton.setOnClickListener {

            /*val email=binding.EmailInputText.text.toString()
            val password=binding.PasswordInputText.text.toString()

            val service=ServiceGenerator.buildService(LoginRetrofit::class.java)
            val call=service.loginData(email,password)
            call.enqueue(object : Callback<login_data> {
                override fun onResponse(call: Call<login_data>, response: Response<login_data>) {
                    if (response.code()==200){
                        Log.e("SUCCESS",response.body().toString())
                        editor.apply{
                            putInt("UserId", response.body()!!.UserId)
                            putString("Name_of_organisation", response.body()!!.NameOfOrgasation)
                            apply()
                        }
                        Toast.makeText(this@LoginActivity,"Login Successful",Toast.LENGTH_SHORT).show()
                        val i=Intent(this@LoginActivity, HomeActivity::class.java)
                        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(i)
                        finish()
                    }
                }

                override fun onFailure(call: Call<login_data>, t: Throwable) {
                    Toast.makeText(this@LoginActivity,t.message, Toast.LENGTH_SHORT).show()
                }

            })*/

            val i=Intent(this@LoginActivity, HomeActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
            finish()
        }

        binding.SignUPbutton.setOnClickListener {
            val intent= Intent(this@LoginActivity,SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
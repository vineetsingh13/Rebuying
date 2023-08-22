package com.example.rebuying

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.rebuying.ChatFragment.ChatActivity
import com.example.rebuying.HomeFragment.HomeFragment
import com.example.rebuying.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.bottom_nav_home->{
                    replaceFragment(HomeFragment())

                }
                R.id.bottom_nav_chat->{
                    val i=Intent(this@HomeActivity,ChatActivity::class.java)
                    startActivity(i)
                }
            }
            true
        }
    }

    override fun onResume() {
        super.onResume()
        binding.bottomNavigationView.menu.findItem(R.id.bottom_nav_home).isChecked=true
    }
    private fun replaceFragment(fragment: Fragment){

        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()


    }
}
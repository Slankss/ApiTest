package com.okankkl.apitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottom : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(FirstFragment())
        bottom = findViewById(R.id.bottomNavigation) as BottomNavigationView

        bottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.firstPage -> loadFragment(FirstFragment())
                R.id.secondPage -> loadFragment(SecondFragment())
                R.id.thirdPage -> loadFragment(ThirdFragment())
            }
            true
        }

    }

    private fun loadFragment(fragment : Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.navHost,fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }



}
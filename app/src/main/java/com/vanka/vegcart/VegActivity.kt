package com.vanka.vegcart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class VegActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_veg)
        supportActionBar?.hide()
          LoadFrag(Home())
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.Home->{
                    LoadFrag(Home())
                    true

                }
                R.id.Cart->{
                    LoadFrag(Cart())
                    true
                }
                R.id.Profile->{
                    LoadFrag(Profile())
                    true
                }
                R.id.Love->{
                    LoadFrag(Love())
                    true
                }


                else -> {
                    LoadFrag(Home())
                    true
                }
            }

        }
    }

    private fun LoadFrag(fragment: Fragment) {
          var load = supportFragmentManager.beginTransaction()
        load.replace(R.id.cont,fragment)
        load.commit()
    }
}
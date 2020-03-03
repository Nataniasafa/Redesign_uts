package com.natania.redesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.natania.redesign.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.nav_home -> {
                    val home_fragment = HomeFragment()
                    addFragment(home_fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_feed -> {
                    val feed_fragment = FeedFragment()
                    addFragment(feed_fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_official -> {
                    val official_fragment = OfficialFragment()
                    addFragment(official_fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_keranjang -> {
                    val keranjang_fragment = KeranjangFragment()
                    addFragment(keranjang_fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_profile-> {
                    val profile_fragment = ProfileFragment()
                    addFragment(profile_fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fm_main_container, fragment, fragment::class.java.simpleName)
            //agar tidak lgsg close
            .addToBackStack(null).commit()
    }
    val defaultMainView = HomeFragment.defultFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        nav_main.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        addFragment(defaultMainView)
    }
}

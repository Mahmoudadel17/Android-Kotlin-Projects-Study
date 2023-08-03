package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false
    lateinit var bottomNav: BottomNavigationView
    private lateinit var viewPager: ViewPager2

    private val homeFragment = HomeFragment()
    private val favoriteFragment = FavoriteFragment()
    private val settingsFragment = SettingsFragment()
    private val searchFragment = SearchFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
        callBack()
    }

    private fun init(){
        bottomNav = findViewById(R.id.bottomNav)
        viewPager = findViewById(R.id.viewPager)


        val adapter = MyFragmentStateAdapter(this)
        adapter.addFragment(homeFragment)
        adapter.addFragment(searchFragment)
        adapter.addFragment(favoriteFragment)
        adapter.addFragment(settingsFragment)
        // Add more fragments as needed
        viewPager.adapter = adapter
    }

    private fun callBack(){
        // when user click on item on buttomNavigation
        bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> viewPager.currentItem = 0
                R.id.search -> viewPager.currentItem = 1
                R.id.favorite -> viewPager.currentItem = 2
                R.id.settings -> viewPager.currentItem = 3

                // Handle other menu items if needed
            }
            true
        }
        // Add a listener to synchronize the BottomNavigationView with the ViewPager2
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bottomNav.selectedItemId = when (position) {
                    0 -> R.id.home
                    1 -> R.id.search
                    2 -> R.id.favorite
                    3 -> R.id.settings



                    // Set the selected item ID for other positions accordingly
                    else -> R.id.bottomNav
                }
            }
        })

    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            finishAffinity() //This will exit the app
        } else {
            doubleBackToExitPressedOnce = true
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
            // Reset the flag after 2 seconds
        }
    }
}
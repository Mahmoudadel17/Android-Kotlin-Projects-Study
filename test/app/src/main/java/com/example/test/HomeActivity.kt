package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false
    lateinit var bottomNav: BottomNavigationView
    lateinit var fragment: FragmentContainerView
    lateinit var iconBack: ImageView

    private val homeFragment = HomeFragment()
    private val favoriteFragment = FavoriteFragment()
    private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
        callBack()
    }

    private fun init(){
        addFragments(homeFragment)

        bottomNav = findViewById(R.id.bottomNav)
        fragment = findViewById(R.id.fragmentHome)
        iconBack = findViewById(R.id.back_button)
    }
    private fun addFragments(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentHome,fragment)
        transaction.commit()
    }
  private fun showFragments(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentHome,fragment)
        transaction.commit()
    }

    private fun callBack(){
        // when user click on item on buttomNavigation
        bottomNav.setOnItemSelectedListener{ item->
            when(item.itemId){
                R.id.home ->{
                    iconBack.visibility  = View.GONE
                    showFragments(homeFragment)
                    true
                }
                R.id.favorite->{
                    iconBack.visibility  = View.VISIBLE
                    showFragments(favoriteFragment)
                    true
                }
                R.id.settings ->{
                    iconBack.visibility  = View.VISIBLE
                    showFragments(settingsFragment)
                    true
                }else -> false
            }
        }

        // when user click on icon back
        iconBack.setOnClickListener {
            iconBack.visibility  = View.GONE
            bottomNav.selectedItemId = R.id.home
            showFragments(homeFragment)
        }
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
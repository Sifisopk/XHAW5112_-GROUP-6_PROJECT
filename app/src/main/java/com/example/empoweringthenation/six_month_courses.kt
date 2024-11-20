package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class six_month_courses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_six_month_courses)

        val firstAidBtn = findViewById<Button>(R.id.childMindingBtn)
        firstAidBtn.setOnClickListener {
            intent = Intent(this, FirstAid::class.java)
            startActivity(intent)
        }

        val sewingBtn = findViewById<Button>(R.id.cookingBtn)
        sewingBtn.setOnClickListener {
            intent = Intent(this, Sewing::class.java)
            startActivity(intent)
        }

        val landScaping = findViewById<Button>(R.id.gardenMaintenanceBtn)
        landScaping.setOnClickListener {
            intent = Intent(this, LandScaping::class.java)
            startActivity(intent)
        }

        val lifeSkills = findViewById<Button>(R.id.lifeSkillsBtn)
        lifeSkills.setOnClickListener {
            intent = Intent(this, LifeSkills::class.java)
            startActivity(intent)
        }

        val homeBtn = findViewById<Button>(R.id.homeBtn)
        homeBtn.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //shopping cart icon
        val shoppingCart: ImageView = findViewById(R.id.shoppingCartImage)
        // Set an OnClickListener to navigate to the shopping cart
        shoppingCart.setOnClickListener {
            intent = Intent(this, Shopping_Cart::class.java)
            startActivity(intent)
        }

        // Find the menu icon ImageView
        val menuIcon: ImageView = findViewById(R.id.menu_icon)
        // Set an onClickListener for the menu icon
        menuIcon.setOnClickListener { view ->
            showPopupMenu(view)
        }
    }


    // Function to show the popup menu
    private fun showPopupMenu(view: View) {
        // Create a PopupMenu
        val popupMenu = PopupMenu(this, view)
        val inflater: MenuInflater = popupMenu.menuInflater
        inflater.inflate(R.menu.menu, popupMenu.menu)  // Make sure `menu.xml` exists!

        // Set click listener for menu items
        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.getQoute -> {
                    val intent = Intent(this, Shopping_Cart::class.java)
                    startActivity(intent)
                    true
                }
                R.id.aboutUs -> {
                    val intent = Intent(this, About_Us::class.java)
                    startActivity(intent)
                    true
                }
                R.id.contactUs -> {
                    val intent = Intent(this, Contact_Us::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        // Show the popup menu
        popupMenu.show()

        }
    }
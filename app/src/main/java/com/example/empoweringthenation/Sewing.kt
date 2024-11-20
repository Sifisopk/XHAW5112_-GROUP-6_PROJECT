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
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Sewing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sewing)
        //go to cart button
        val selectBtn1 = findViewById<Button>(R.id.selectBtn1)
        selectBtn1.setOnClickListener {
            intent = Intent(this, Shopping_Cart::class.java)
            startActivity(intent)
        }
        //back button
        val backBtn = findViewById<Button>(R.id.backBtn)
        backBtn.setOnClickListener {
            intent = Intent(this, six_month_courses::class.java)
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
package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Shopping_Cart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shopping_cart)

        //btn to go back to previous screen
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        // Prices of courses
        val coursePrices = mapOf(
            "course1" to 1500.0,
            "course2" to 1500.0,
            "course3" to 1500.0,
            "course4" to 1500.0,
            "course5" to 750.0,
            "course6" to 750.0,
            "course7" to 750.0,
        )
        val vatRate = 0.15
        val discount = 0.10 // 10% discount for example

            // Get references to UI elements
            val nameInput = findViewById<EditText>(R.id.nameInput)
            val phoneInput = findViewById<EditText>(R.id.phoneInput)
            val emailInput = findViewById<EditText>(R.id.emailInput)

            val course1 = findViewById<CheckBox>(R.id.course1)
            val course2 = findViewById<CheckBox>(R.id.course2)
            val course3 = findViewById<CheckBox>(R.id.course3)
            val course4 = findViewById<CheckBox>(R.id.course4)
            val course5 = findViewById<CheckBox>(R.id.course5)
            val course6 = findViewById<CheckBox>(R.id.course6)
            val course7 = findViewById<CheckBox>(R.id.course7)

            val calculateBtn = findViewById<Button>(R.id.calculateBtn)
            val totalFeeText = findViewById<TextView>(R.id.totalFeeText)

            // Set onClickListener for the button
            calculateBtn.setOnClickListener {
                // Validate user input
                if (nameInput.text.isBlank() || phoneInput.text.isBlank() || emailInput.text.isBlank()) {
                    Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Calculate total fees
                var totalFee = 0.0

                if (course1.isChecked) totalFee += coursePrices["course1"]!!
                if (course2.isChecked) totalFee += coursePrices["course2"]!!
                if (course3.isChecked) totalFee += coursePrices["course3"]!!
                if (course4.isChecked) totalFee += coursePrices["course4"]!!
                if (course5.isChecked) totalFee += coursePrices["course5"]!!
                if (course6.isChecked) totalFee += coursePrices["course6"]!!
                if (course7.isChecked) totalFee += coursePrices["course7"]!!

                // Apply discount if eligible
                val discountedFee = totalFee * (1 - discount)

                // Apply VAT
                val totalWithVat = discountedFee * (1 + vatRate)

                // Update the total fee TextView
                totalFeeText.text = "Total: R%.2f".format(totalWithVat)


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
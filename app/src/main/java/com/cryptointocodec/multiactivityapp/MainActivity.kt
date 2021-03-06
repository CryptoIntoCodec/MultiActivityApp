package com.cryptointocodec.multiactivityapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var quantity = 0

    /**
     * This method is called when the order button is clicked.
     */
    fun submitOrder(view: View?) {
        display(quantity)
        var stringPriceMessage = "total: " + quantity + " cups of coffee, total cost Rs." + quantity * 10
        displayMessage(stringPriceMessage)
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private fun display(number: Int) {
        val textView = findViewById<View>(R.id.textView2) as TextView
        textView.text = "" + number
    }

    /**
     * This method displays the given price on the screen.
     */
    private fun displayPrice(number: Int) {
        val priceTextView = findViewById<View>(R.id.price_text_view) as TextView
        priceTextView.text = NumberFormat.getCurrencyInstance().format(number)
    }

    private fun displayMessage(message: String) {
        val priceTextView = findViewById(R.id.price_text_view) as TextView
        priceTextView.setText(message)
    }

    fun decrease(view: View) {
        if (quantity > 0) {
            quantity -= 1
            display(quantity)
        } else
            Toast.makeText(this, "Minimum 1 cup of coffee", Toast.LENGTH_SHORT).show()
    }

    fun increment(view: View) {
        quantity += 1
        display(quantity)
    }
}
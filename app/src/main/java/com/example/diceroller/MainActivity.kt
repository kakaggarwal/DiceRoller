package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the button in the layout
        val rollButton: Button = findViewById(R.id.button)

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Rolls the dice and updates the screen with the result.
     */
    private fun rollDice() {
        // Creates a new Dice object and rolls it
        val diceRoll = Dice(6).roll()

        // Display a Toast with text Dice Rolled!
        Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

        // Updates the screen with the dice roll result
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

/**
 * Dice with a fixed number of sides.
 */
class Dice(private val sides: Int) {

    /**
     * Does a random dice roll and returns the result
     */
    fun roll(): Int {
        return (1..sides).random()
    }
}
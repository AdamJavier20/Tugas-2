package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var FirstNumber: EditText
    private lateinit var SecondNumber: EditText
    private lateinit var Group: RadioGroup
    private lateinit var Button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        FirstNumber = findViewById(R.id.first_number)
        SecondNumber = findViewById(R.id.second_number)
        Group = findViewById(R.id.radio_group)
        Button = findViewById(R.id.button)


        Button.setOnClickListener {

            val firstNumberStr = FirstNumber.text.toString()
            val secondNumberStr = SecondNumber.text.toString()


            if (firstNumberStr.isEmpty() || secondNumberStr.isEmpty()) {
                Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val Number1 = firstNumberStr.toDouble()
            val Number2 = secondNumberStr.toDouble()


            val selectedOperation = Group.checkedRadioButtonId

            if (selectedOperation == -1) {
                Toast.makeText(this, "Please select an operation", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var hasil = 0.0


            val selectedRadioButton: RadioButton = findViewById(selectedOperation)
            val operation = selectedRadioButton.text.toString()

            when (operation) {
                "+" -> hasil = Number1 + Number2
                "-" -> hasil = Number1 - Number2
                "*" -> hasil = Number1 * Number2
                "/" -> {
                    if (Number2 != 0.0) {
                        hasil = Number1 / Number2
                    } else {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                }
            }


            val intent = Intent(this, Hasil::class.java)
            intent.putExtra("hasil", hasil)
            startActivity(intent)
        }
    }
}
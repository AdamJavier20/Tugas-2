package com.example.tugas2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Hasil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hasil)

        val hasil = intent.getDoubleExtra("hasil", 0.0)

        val HasilTotal: TextView = findViewById(R.id.HasilTotal)
        HasilTotal.text = "Hasil: $hasil"
    }
}







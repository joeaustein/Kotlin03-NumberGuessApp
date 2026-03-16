package com.example.kotlin03_numberguessapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.enums.enumEntries

class MainActivity : AppCompatActivity() {
    private var sortedNumber: Int = 0
    private var tries: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Implementacoes:
        sortedNumber = (1 .. 100).random()
        tries = 0
        println("Sorted Number = $sortedNumber")
        // Acao:
        val botaoAdivinhar = findViewById<Button>(R.id.ButtonAdivinhar)
        botaoAdivinhar.setOnClickListener {
            guess()
        }
    }

    fun guess() {
        val input = findViewById<EditText>(R.id.EditTextInput)
        val output = findViewById<TextView>(R.id.TextViewOutput)
        var tip: String = "Número sorteado é maior!"

        val inputNumber = input.text.toString().toIntOrNull()

        if(inputNumber == null || (inputNumber > 100 || inputNumber < 0)) {
            Toast.makeText(this, "Forneca um número entre 0 e 100!", Toast.LENGTH_SHORT).show()
            tip = "Valor invalido"
        }
        else {
            tries++
            if (sortedNumber < inputNumber)
                tip = "Número sorteado é menor!"
            else if (sortedNumber == inputNumber)
                tip = "Acertou!\nVocê usou $tries tentativas."
        }
        output.text = tip
    }
}
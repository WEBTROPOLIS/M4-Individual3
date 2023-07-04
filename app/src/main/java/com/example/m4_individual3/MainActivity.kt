package com.example.m4_individual3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val screen1 = findViewById<TextView>(R.id.Screen1)
        val screen2 = findViewById<TextView>(R.id.Screen2)
        val numUser = findViewById<EditText>(R.id.numUser)
        val mas = findViewById<Button>(R.id.mas)
        val resta = findViewById<Button>(R.id.resta)
        val div = findViewById<Button>(R.id.div)
        val por = findViewById<Button>(R.id.por)
        val igual = findViewById<Button>(R.id.igual)
        val exit = findViewById<Button>(R.id.exit)
        val c = findViewById<Button>(R.id.c)
        exit.setOnClickListener { finish() }
        c.setOnClickListener {
            screen1.text = ""
            screen2.text = ""
            numUser.setText("")
        }
        mas.setOnClickListener {
            val txt = numUser.text.toString()
            if (!txt.isEmpty()) {
                screen1.text = txt
                screen2.text = "+ "
                numUser.setText("")
            } else {
                Toast.makeText(this@MainActivity, "Debe Ingresar un Valor", Toast.LENGTH_LONG)
                    .show()
            }
        }
        resta.setOnClickListener {
            val txt = numUser.text.toString()
            if (!txt.isEmpty()) {
                screen1.text = txt
                screen2.text = "- "
                numUser.setText("")
            } else {
                Toast.makeText(this@MainActivity, "Debe Ingresar un Valor", Toast.LENGTH_LONG)
                    .show()
            }
        }
        div.setOnClickListener {
            val txt = numUser.text.toString()
            if (!txt.isEmpty()) {
                screen1.text = txt
                screen2.text = "/ "
                numUser.setText("")
            } else {
                Toast.makeText(this@MainActivity, "Debe Ingresar un Valor", Toast.LENGTH_LONG)
                    .show()
            }
        }
        por.setOnClickListener {
            val txt = numUser.text.toString()
            if (!txt.isEmpty()) {
                screen1.text = txt
                screen2.text = "* "
                numUser.setText("")
            } else {
                Toast.makeText(this@MainActivity, "Debe Ingresar un Valor", Toast.LENGTH_LONG)
                    .show()
            }
        }
        igual.setOnClickListener {
            val num1 = screen1.text.toString()
            val op = screen2.text.toString().trim { it <= ' ' }
            val num2 = numUser.text.toString()
            if (!num2.isEmpty()) {
                var resultado = 0.0
                var flagDivCero = true
                when (op) {
                    "+" -> {
                        resultado = num1.toDouble() + num2.toDouble()
                        screen2.text = "+$num2"
                    }

                    "-" -> {
                        resultado = num1.toDouble() - num2.toDouble()
                        screen2.text = "-$num2"
                    }

                    "*" -> {
                        resultado = num1.toDouble() * num2.toDouble()
                        screen2.text = "*$num2"
                    }

                    "/" -> if (num2 != "0") {
                        resultado = num1.toDouble() / num2.toDouble()
                        screen2.text = "/$num2"
                    } else {
                        flagDivCero = false
                        Toast.makeText(
                            this@MainActivity,
                            "No se puede dividir por cero",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                if (flagDivCero) {
                    numUser.setText(resultado.toString())
                } else {
                    numUser.setText("Error al dividir por cero")
                }
            } else {
                Toast.makeText(this@MainActivity, "Debe Ingresar un Valor", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}
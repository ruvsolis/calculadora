package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener { numSelec( digito = "1") }
        btn2.setOnClickListener { numSelec( digito = "2") }
        btn3.setOnClickListener { numSelec( digito = "3") }
        btn4.setOnClickListener { numSelec( digito = "4") }
        btn5.setOnClickListener { numSelec( digito = "5") }
        btn6.setOnClickListener { numSelec( digito = "6") }
        btn7.setOnClickListener { numSelec( digito = "7") }
        btn8.setOnClickListener { numSelec( digito = "8") }
        btn9.setOnClickListener { numSelec( digito = "9") }
        btn0.setOnClickListener { numSelec( digito = "0") }

        btnSumar.setOnClickListener { operacionPresionada(SUMA) }
        btnRestar.setOnClickListener { operacionPresionada(RESTA) }
        btnMultiplicar.setOnClickListener { operacionPresionada(MULTIPLICACION) }
        btnDividir.setOnClickListener { operacionPresionada(DIVISION) }

        btnBorrar.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            resultadoViewText.text = ""
            operacion = NO_OPERACION
        }
        btnBorrarTodo.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            resultadoViewText.text = ""
            operacion = NO_OPERACION
        }

        btnIgual.setOnClickListener {
            var resultado = when(operacion) {
                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIPLICACION -> num1 * num2
                DIVISION -> num1 / num2
                else -> ""
            }
            resultadoViewText.text = resultado.toString()
        }
    }

    private fun numSelec(digito: String) {
        resultadoViewText.text = "${resultadoViewText.text}$digito"
        if(operacion == NO_OPERACION) {
            num1 = resultadoViewText.text.toString().toDouble()
        } else {
            num2 = resultadoViewText.text.toString().toDouble()
        }
    }

    private fun operacionPresionada(operacion: Int) {
        this.operacion = operacion

        resultadoViewText.text = ""
    }

    companion object {
        const val SUMA = 1
        const val  RESTA = 2
        const val MULTIPLICACION = 3
        const val  DIVISION = 4
        const val NO_OPERACION = 0
    }
}
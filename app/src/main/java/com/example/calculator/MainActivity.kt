package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var firstValue: String = ""
    private var secondValue: String = ""
    private var operator: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Number button click listeners
        binding.btnNZero.setOnClickListener {
            appendNumber("0")
        }
        binding.btnNOne.setOnClickListener {
            appendNumber("1")
        }
        binding.btnNTwo.setOnClickListener {
            appendNumber("2")
        }
        binding.btnNThree.setOnClickListener {
            appendNumber("3")
        }
        binding.btnNFour.setOnClickListener {
            appendNumber("4")
        }
        binding.btnNFive.setOnClickListener {
            appendNumber("5")
        }
        binding.btnNSix.setOnClickListener {
            appendNumber("6")
        }
        binding.btnNSeven.setOnClickListener {
            appendNumber("7")
        }
        binding.btnNEight.setOnClickListener {
            appendNumber("8")
        }
        binding.btnNNine.setOnClickListener {
            appendNumber("9")
        }
        binding.btnNDot.setOnClickListener {
            appendNumber(".")
        }

        // Operator button click listeners
        binding.btnAddition.setOnClickListener {
            operator = "+"
        }
        binding.btnSubtraction.setOnClickListener {
            operator = "-"
        }
        binding.btnDivision.setOnClickListener {
            operator = "/"
        }
        binding.btnMultiplication.setOnClickListener {
            operator = "*"
        }
        binding.btnPercentage.setOnClickListener {
                val num1 = firstValue.toFloatOrNull() ?: 0f
                val result = num1 / 100

                binding.tvResult.text = result.toString()
                firstValue = result.toString()
                secondValue = ""
                operator = ""
        }
        binding.btnPositiveNegative.setOnClickListener {
            var num1 = firstValue.toFloatOrNull() ?: 0f
            var num2 = secondValue.toFloatOrNull() ?: 0f

            if(num1 > 0 || num2 > 0){
                num1 *= -1
                num2 *= -1
            } else{
                num1 *= 1
                num2 *= 1
            }
            println(num1)
        }

        binding.btnClean.setOnClickListener {
            firstValue = ""
            secondValue = ""
            operator = ""
            binding.tvResult.text = ""
        }

        binding.btnResult.setOnClickListener { calculateResult() }
    }

    private fun appendNumber(number: String) {
        if (operator.isEmpty()) {
            firstValue += number
        } else {
            secondValue += number
        }
        updateDisplay()
    }

    private fun calculateResult() {
        if (firstValue.isNotEmpty() && secondValue.isNotEmpty() && operator.isNotEmpty()) {
            val num1 = firstValue.toFloatOrNull() ?: 0f
            val num2 = secondValue.toFloatOrNull() ?: 0f
            println(num1)
            println(num2)
            val result = when (operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0f) num1 / num2 else Float.NaN
                else -> Float.NaN
            }
            binding.tvResult.text = result.toString()
            firstValue = result.toString()
            secondValue = ""
            operator = ""

        }

    }

    private fun updateDisplay() {
        binding.tvResult.text = if (operator.isEmpty()) firstValue else secondValue
    }


}
package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var operand = 0.0
    private var operation = ""
    private var point = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun numberClick(clickedView: View) {
        if (clickedView is Button) {
            val number = clickedView.text.toString()
            var result = resultTextView.text.toString()
            if (result == "0")
                result = ""
            resultTextView.text = result + number
        }


    }
    fun operationClick(clickedView: View){

        if(clickedView is Button){
            point = true
            var resultText = resultTextView.text.toString()
            if (resultText.isEmpty())
                return
            operand = resultText.toDouble()
            operation = clickedView.text.toString()
            resultTextView.text = ""


        }
    }
    fun equalsClick(clickedView: View) {
        point = true
        val resultText = resultTextView.text.toString()
        if (resultText.isEmpty())
            return
        val secondOperand = resultText.toDouble()
        var result = 0.0
        if(operation == "+"){
            result = (operand.toDouble() + secondOperand).toString().toDoubleOrNull()!!
            if(result == null){
                resultTextView.text = (operand + secondOperand).toString().toInt().toString()

            } else {
                resultTextView.text = result.toString().toDouble().toString()
            }



        } else if (operation =="-"){
            result = (operand.toDouble() -  secondOperand).toString().toDoubleOrNull()!!
            if(result == null){
                resultTextView.text = (operand.toDouble() - secondOperand).toString()

            } else {
                resultTextView.text = result.toString().toDouble().toString()
            }

        } else if (operation == "*"){
            result = (operand.toDouble() * secondOperand).toString().toDoubleOrNull()!!
            if(result == null){
                resultTextView.text = (operand.toDouble() * secondOperand).toString().toInt().toString()

            } else {
                resultTextView.text = result.toString().toDouble().toString()
            }

        } else if (operation == "/"){
            result = (operand.toDouble() / secondOperand).toString().toDoubleOrNull()!!
            if(result == null){
                resultTextView.text = (operand.toDouble() / secondOperand).toString().toInt().toString()

            } else {
                resultTextView.text = result.toString().toDouble().toString()
            }

        }


    }

    fun clearClick(clickedView: View) {
        resultTextView.text = ""
        point = true

    }
    

    
    fun point(view: View) {
        var checkDouble = resultTextView.text.toString().toDoubleOrNull()
        if(checkDouble != null){
            point = true


        }

        if (point == true){
            resultTextView.text = resultTextView.text.toString() + "."
            point = false

        }

    }
    fun del(view: View) {
        val text = resultTextView.text.toString()
        if(text.isNotEmpty()){


            resultTextView.text = text.dropLast(1)
        }else{
            resultTextView.text = ""
        }


    }

}

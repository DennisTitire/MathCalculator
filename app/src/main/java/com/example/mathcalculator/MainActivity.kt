package com.example.mathcalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mathcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var canAddOperation = false
    private lateinit var workingTextView: TextView
    private lateinit var resultTextView: TextView

    private lateinit var workingList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.customToolbar)

        workingTextView = binding.workingTv
        resultTextView = binding.resultTv

    }

    fun allClearAction(view: View) {
        workingTextView.text = ""
        resultTextView.text = ""
    }

    fun equalsAction(view: View) {
        val workingList = workingTextView.text
    }

    fun backSpaceAction(view: View) {
        val lengthWorking = workingTextView.text.length
        val lengthResult = resultTextView.text.length
        if (lengthWorking > 0) {
            workingTextView.text = workingTextView.text.substring(0, lengthWorking - 1)
        } else if (lengthResult > 0) {
            resultTextView.text = resultTextView.text.substring(0, lengthResult - 1)
        } else {
            Toast.makeText(this, "Nothing to clear!", Toast.LENGTH_SHORT).show()
        }
    }

    fun numberAction(view: View) {
        if (view is Button) {
            binding.workingTv.append(view.text)
            canAddOperation = true
        }
    }

    fun operatorAction(view: View) {
        if (view is Button && canAddOperation) {
            binding.workingTv.append(view.text)
            canAddOperation = false
        }
    }

}
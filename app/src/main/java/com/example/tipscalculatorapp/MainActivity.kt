package com.example.tipscalculatorapp

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.tipscalculatorapp.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    /*declares a top-level variable in the class for the binding object
    that  will be used across multiple methods in MainActivity class
     */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* initializes the binding object which will be use to access Views in the activity_main.xml*/
        binding = ActivityMainBinding.inflate(layoutInflater)
        //specifies the root of the hierarchy of views in app,
        setContentView(binding.root)

        binding.btnCalculateTip.setOnClickListener {
            calculateTip()
        }

        binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(
                view,
                keyCode
            )
        }


    }

    private fun calculateTip() {
        val stringInTextField = binding.edtServiceCoast.toString()
        val cost = stringInTextField.toDoubleOrNull()

        if (cost == null || cost == 0.0) {
            displayTip(0.0)
            return
        }

        val tipPercentage = when (binding.rgTipOptions.checkedRadioButtonId) {
            R.id.rbOptionOne -> 0.20
            R.id.optionTwo -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage.times(cost)

        val roundUp = binding.roundUpSwitch.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }

        displayTip(tip)

    }

    private fun displayTip(tip: Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(0.0)
        binding.tvTipResult.text = getString(R.string.tip_amount, formattedTip)
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }

}
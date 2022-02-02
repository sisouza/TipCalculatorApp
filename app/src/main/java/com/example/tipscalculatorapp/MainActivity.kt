package com.example.tipscalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }

    private fun calculateTip() {
        val stringInTextField = binding.edtServiceCoast.text.toString()
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
}
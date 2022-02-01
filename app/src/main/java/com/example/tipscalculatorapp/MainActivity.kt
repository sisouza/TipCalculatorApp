package com.example.tipscalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipscalculatorapp.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    /*declares a top-level variable in the class for the binding object
    that  will be used across multiple methods in MainActivity class
     */
    lateinit var binding: ActivityMainBinding

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

    fun calculateTip() {
        val stringInTextField = binding.edtServiceCoast.text
        val cost = stringInTextField.toDoubleOrNull()

        if (cost == null) {
            binding.tvTipResult.text = ""
            return
        }

        val selectedId = binding.rgTipOptions.checkedRadioButtonId

        val tipPercentage = when (selectedId) {
            R.id.rbOptionOne -> 0.20
            R.id.optionTwo -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost
        val roundUp = binding.roundUpSwitch.isChecked

        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tvTipResult.text = getString(R.string.tip_amount, formatted

    }
}
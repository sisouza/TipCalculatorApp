package com.example.tipscalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipscalculatorapp.databinding.ActivityMainBinding

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
    }
}
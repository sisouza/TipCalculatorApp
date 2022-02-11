package com.example.tipscalculatorapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTest {

    //the first thing is launch our activity
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

}
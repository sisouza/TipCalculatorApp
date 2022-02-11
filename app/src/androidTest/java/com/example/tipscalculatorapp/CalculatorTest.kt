package com.example.tipscalculatorapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CalculatorTest {

    //the first thing is launch our activity
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip() {
        onView(withId(R.id.edtServiceCoast))
            .perform(typeText("50.00"))

        //search button and click
        onView(withId(R.id.btnCalculateTip))
            .perform(click())

        //what is expected
        onView(withId(R.id.tvTipResult))
            .check(matches(withText(containsString("$10.00"))))


    }


    /*
    * akes a ViewMatcher object parameter.
    * A ViewMatcher is essentially a UI component that matches a particular criteria,
    *  which in this case is a component that has the ID */


}
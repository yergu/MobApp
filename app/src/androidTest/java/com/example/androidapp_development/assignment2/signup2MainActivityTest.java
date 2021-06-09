package com.example.androidapp_development.assignment2;

import android.widget.DatePicker;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.androidapp_development.R;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.PickerActions.setDate;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

public class signup2MainActivityTest {

    @Rule
    public ActivityScenarioRule<signup2MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(signup2MainActivity.class);
    @Test
    public void hasName() {
        onView(withId(R.id.name)).perform(typeText("FirstName"),
                closeSoftKeyboard());
        onView(withId(R.id.name)).check(matches(withText("FirstName")));
    }
    public static final String name="Yergalem";
    @Test
    public void tastValidEmail() {
        onView(withId(R.id.email)).perform(typeText("email@gmai.com"),
                closeSoftKeyboard());
        onView(withId(R.id.email)).check(matches(withText("email@gmai.com")));
    }

    @Test
    public void testSignupFunctionality() {
        // Type text and then press the button.
        onView(withId(R.id.name)).perform(typeText("FirstName"),
                closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText("yergalemt@gmail.com"),
                closeSoftKeyboard());
        onView(withId(R.id.description)).perform(typeText("description"),
                closeSoftKeyboard());
        // Show the date picker
        onView(withId(R.id.dob)).perform(click());
        // Sets a date on the date picker widget
        onView(isAssignableFrom(DatePicker.class)).perform(setDate(1980, 10, 30));
        // Confirm the selected date. This example uses a standard DatePickerDialog
        // which uses
        // android.R.id.button1 for the positive button id.
        onView(withId(android.R.id.button1)).perform(click());
        // Check if the selected date is correct and is displayed in the Ui.
        onView(withId(R.id.dob)).check(matches(allOf(withText("10/30/1980"),
                isDisplayed())));
        onView(withId(R.id.submit)).perform(click());
    }
    @Test
    public void testSetDateInDatePicker() {
        // Show the date picker
        onView(withId(R.id.dob)).perform(click());
        // Sets a date on the date picker widget
        onView(isAssignableFrom(DatePicker.class)).perform(setDate(1980, 10, 30));
        // Confirm the selected date. This example uses a standard DatePickerDialog
        // which uses
        // android.R.id.button1 for the positive button id.
        onView(withId(android.R.id.button1)).perform(click());
        // Check if the selected date is correct and is displayed in the Ui.
        onView(withId(R.id.dob)).check(matches(allOf(withText("10/30/1980"),
                isDisplayed())));
    }

    @Test
    public void tastValidDescription() {
        onView(withId(R.id.description)).perform(typeText(name));
                closeSoftKeyboard();
        onView(withId(R.id.description)).check(matches(withText(name)));
    }
}
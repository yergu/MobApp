package com.example.androidapp_development;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.androidapp_development.assignment4.Assignment4Signup;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

//import OldVersion.MainActivity;
@RunWith(JUnit4.class)
public class assignment4SingupTest {


    private String stringToBetyped;

    @Rule
    public ActivityScenarioRule<Assignment4Signup> activityRule
            = new ActivityScenarioRule<>(Assignment4Signup.class);


    @Before
    public void setUp() throws Exception {
        //Before Test case execution
    }
    public void initValidString()
    {
        // Specify a valid string.
        stringToBetyped = "test";
    }

    @Test
    public void isActivitylounch() {
        onView(withId(R.id.sinaupc)).check(matches(isDisplayed())); //
    }

    @Test
    public void isButtonsVisible() {
        onView(withId(R.id.create_profile)).check(matches(isDisplayed())); //
        //onView(withId(R.id.assignment4)).check((ViewAssertion) withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE));//METHOD 2 OF Checking is displayed
    }

    @Test
    public void hasName() {
        onView(withId(R.id.name)).perform(typeText("FirstName"),
                closeSoftKeyboard());
        onView(withId(R.id.name)).check(matches(withText("FirstName")));
    }

  @Test
    public void tastValidEmail() {
        onView(withId(R.id.emailadd)).perform(typeText("email@gmai.com"),
                closeSoftKeyboard());
        onView(withId(R.id.emailadd)).check(matches(withText("email@gmai.com")));
    }
    @Test
    public void tastValidOccupation() {
        onView(withId(R.id.occupation)).perform(typeText("Occupation"),
                closeSoftKeyboard());
        onView(withId(R.id.occupation)).check(matches(withText("Occupation")));
    }
    @Test
    public void tastValidDescription() {
        onView(withId(R.id.occupation)).perform(typeText("Occupation"),
                closeSoftKeyboard());
        onView(withId(R.id.occupation)).check(matches(withText("Occupation")));
    }


/*
    @Test
    public void testEnterData() {
        onView(withId(R.id.name)).perform(typeText("namem"));
        onView(withId(R.id.emailadd)).perform(typeText("email@gmai.com"));
        onView(withId(R.id.occupation)).perform(typeText("Occupation"));
           onView(withId(R.id.description)).perform(typeText("Description"));

        onView(withId(R.id.create_profile))
                .check(matches(isDisplayed()))
                .perform(doubleClick());


      //  onView(withId(R.id.)).perform(click());
    }*/

    @After
    public void tearDown() throws Exception {
        //After Test case Execution
    }


}
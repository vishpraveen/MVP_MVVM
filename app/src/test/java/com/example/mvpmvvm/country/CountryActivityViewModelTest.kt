package com.example.mvpmvvm.country

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mvpmvvm.Utility
import com.example.mvpmvvm.getOrAwaitValue
import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CountryActivityViewModelTest {
    private lateinit var countryActivityViewModel: CountryActivityViewModel
    val countries = listOf<String>("China",
        "India",
        "United States",
        "Indonesia",
        "Pakistan",
        "Brazil",
        "Nigeria",
        "Bangladesh",
        "Russia",
        "Mexico",
        "Japan")

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        // Given a fresh ViewModel
        countryActivityViewModel = CountryActivityViewModel(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun get_countries_from_countries_json_file() {

        countryActivityViewModel.fetchCountriesListFromFile()

        // Then the new task is triggered
        val value = countryActivityViewModel.getCountries().getOrAwaitValue()

        assertThat(countries, `is`(value))
    }
}
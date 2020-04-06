package com.example.mvpmvvm

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mvpmvvm.country.CountryModel
import org.hamcrest.core.Is.`is`
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock

@RunWith(AndroidJUnit4::class)
class UtilityTest {

    @Mock
    val utility = Utility

    private lateinit var context: Context

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

    @Before
    fun setUp() {
        context =ApplicationProvider.getApplicationContext()
    }

    @Test
    fun get_countries_from_null_file_name_returnsEmptyList() {

        val result = utility.getStringFromFile(context, null)

        assertEquals(emptyList<String>(), result)
    }

    @Test
    fun get_countries_from_blank_file_name_returnsEmptyList() {

        val result = utility.getStringFromFile(context, "")

        assertEquals(emptyList<String>(), result)
    }

    @Test
    fun get_countries_from_countries_json_file() {

        val result = utility.getStringFromFile(context, "countries.json")

        assertEquals(countries, result)
    }
}
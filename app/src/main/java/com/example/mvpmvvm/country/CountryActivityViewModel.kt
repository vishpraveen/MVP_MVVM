package com.example.mvpmvvm.country

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvpmvvm.Utility

class CountryActivityViewModel(application: Application): AndroidViewModel(application) {

    private val TAG = CountryActivityViewModel::class.java.simpleName
    private val countries : MutableLiveData<List<String>> = MutableLiveData()

    fun getCountries(): LiveData<List<String>> {
        return countries
    }

    fun fetchCountriesListFromFile() {
        val countryJson = Utility.getStringFromFile(
            getApplication(),
            "countries.json"
        )

//        Log.i(TAG, "JSONObject $countryJson")

        countries.value = countryJson
    }
}
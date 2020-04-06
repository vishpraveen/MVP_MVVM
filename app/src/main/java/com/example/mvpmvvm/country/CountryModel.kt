package com.example.mvpmvvm.country

import com.google.gson.annotations.SerializedName

data class CountryModel(@SerializedName("countryList") val countries: List<String>) {

}
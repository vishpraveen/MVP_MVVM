package com.example.mvpmvvm.country

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpmvvm.R
import com.example.mvpmvvm.Utility
import kotlinx.android.synthetic.main.activity_country.*
import org.json.JSONArray
import org.json.JSONObject

class CountryActivity : AppCompatActivity() {
    private val TAG = CountryActivity::class.java.simpleName
    private lateinit var countryActivityViewModel: CountryActivityViewModel
    private var countryList: ArrayList<String> = ArrayList()
    private lateinit var countryListAdapter: CountryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        countryActivityViewModel = ViewModelProvider(this@CountryActivity).get(CountryActivityViewModel::class.java)

        initializeUI()

        countryActivityViewModel.getCountries().observe(this, Observer { countries ->
            if (!countries.isNullOrEmpty()){
                for (country in countries){
                    println(country)
                }
                countryList.clear()
                countryList.addAll(countries)
                countryListAdapter.notifyDataSetChanged()
            }
        })

        countryActivityViewModel.fetchCountriesListFromFile()
    }

    private fun initializeUI() {
        val linearLayout = LinearLayoutManager(rvCountryList.context)
        rvCountryList.layoutManager = linearLayout
        val itemDecoration = DividerItemDecoration(rvCountryList.context,linearLayout.orientation)
        rvCountryList.addItemDecoration(itemDecoration)
        countryListAdapter = CountryListAdapter(countryList)
        rvCountryList.adapter = countryListAdapter
    }
}

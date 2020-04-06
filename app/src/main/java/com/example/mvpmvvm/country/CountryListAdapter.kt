package com.example.mvpmvvm.country

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpmvvm.R
import com.google.android.material.textview.MaterialTextView
import java.util.ArrayList

class CountryListAdapter(private val countryList: ArrayList<String>) :
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.tvCountry.text = countryList[position]
    }

    inner class CountryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvCountry: MaterialTextView = itemView.findViewById(R.id.tvCountry)
    }
}

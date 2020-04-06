package com.example.mvpmvvm

import android.content.Context
import android.util.Log
import com.example.mvpmvvm.country.CountryModel
import com.google.gson.GsonBuilder
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream
import java.lang.Exception

object Utility {
    private val TAG = Utility::class.java.simpleName

    fun getStringFromFile(context: Context, fileName: String?): List<String>? {
        var json: String? = null


        try {
            if (fileName?.isNotEmpty()!!) {
                val inputStream : InputStream = context.assets.open(fileName)
                json = inputStream.bufferedReader().use { it.readText() }
            }else{
                return emptyList()
            }
        }catch (ex: Exception){
            ex.printStackTrace()
            return emptyList()
        }

        val gson = GsonBuilder().create()

//        Log.i(TAG, "JSONObject: $json")

        val countryModel = gson.fromJson(json, CountryModel::class.java)

//        Log.i(TAG, "Countries size: ${countryModel.countries.size}")
        return countryModel.countries
    }

    /*fun getJsonArrayFromJsonObject(jsonObject: JSONObject?, key: String): JSONArray?{
        val jsonArray = jsonObject?.getJSONArray(key)
        Log.i(TAG, "JSONArray: $jsonArray")
        return jsonArray
    }*/

}
package com.example.mvpmvvm.login

interface LoginView {

    fun clearFields()

    fun showProgressbar()

    fun hideProgressbar()

    fun getEmail(): String

    fun getPassword():String

    fun setErrorMessage(viewId: Int, msg: String)

    fun login()
}
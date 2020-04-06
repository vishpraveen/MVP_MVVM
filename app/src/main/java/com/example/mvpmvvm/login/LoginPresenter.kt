package com.example.mvpmvvm.login

interface LoginPresenter {

    fun isValidDetails(email: String?, password: String?): Boolean

    fun clear()

    fun onDestroy()
}
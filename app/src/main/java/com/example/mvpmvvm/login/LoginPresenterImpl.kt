package com.example.mvpmvvm.login

import android.text.TextUtils
import android.util.Patterns
import com.example.mvpmvvm.R

class LoginPresenterImpl (var loginView: LoginView?): LoginPresenter{

    override fun clear() {
        loginView?.clearFields()
    }

    override fun isValidDetails(email: String?, password: String?): Boolean {
        loginView?.showProgressbar()
        loginView?.setErrorMessage(R.id.etEmail, "")
        loginView?.setErrorMessage(R.id.etPassword, "")
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email!!).matches()){
            loginView?.setErrorMessage(R.id.etEmail, "Invalid Email.")
            return false
        }else if (TextUtils.isEmpty(password)){
            loginView?.setErrorMessage(R.id.etPassword, "Invalid Password.")
            return false
        }
        return true

    }

    override fun onDestroy() {
        loginView = null
    }
}
package com.example.mvpmvvm.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvpmvvm.R
import com.example.mvpmvvm.country.CountryActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {
    private val TAG: String = LoginActivity::class.java.simpleName

    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenterImpl(this)

        btnClear.setOnClickListener {
            loginPresenter.clear()
        }

        btnLogin.setOnClickListener {
            if(loginPresenter.isValidDetails(etEmail.text.toString(), etPassword.text.toString())){
                login()
            }
        }
    }

    override fun login() {
        startActivity(Intent(this@LoginActivity, CountryActivity::class.java))
        hideProgressbar()
        finish()
    }

    override fun getEmail(): String {
        return etEmail.text.toString()
    }

    override fun getPassword(): String {
        return etPassword.text.toString()
    }

    override fun setErrorMessage(viewId: Int, msg: String) {
        if (msg.isEmpty()){
            tilEmail.error = null
            tilPassword.error = null
        }else{
            if (viewId==R.id.etEmail){
                hideProgressbar()
                tilEmail.error = msg
                etEmail.requestFocus()
            }else if (viewId==R.id.etPassword){
                hideProgressbar()
                tilPassword.error = msg
                etPassword.requestFocus()
            }
        }
    }

    override fun clearFields() {
        etEmail.setText("")
        etPassword.setText("")
    }

    override fun showProgressbar() {
        loginProgressBar.visibility = View.VISIBLE
    }

    override fun hideProgressbar() {
        loginProgressBar.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::loginPresenter.isInitialized){
            loginPresenter.onDestroy()
        }
    }
}

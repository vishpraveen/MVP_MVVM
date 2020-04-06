package com.example.mvpmvvm.login

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class LoginPresenterImplTest {

    private lateinit var loginPresenterImpl: LoginPresenterImpl

    @Mock
    private lateinit var loginView: LoginView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        loginPresenterImpl = LoginPresenterImpl(loginView)
    }

    @Test
    fun isValidDetails_both_email_and_password_is_empty_returnFalse() {
        val email = ""
        val password = ""

        val result = loginPresenterImpl.isValidDetails(email, password)

        assertThat(false,`is`(result))
    }

    @Test
    fun isValidDetails_invalid_email_and_password_returnsFalse() {
        val email = "abc.com"
        val password ="asd@123"

        val result = loginPresenterImpl.isValidDetails(email, password)

        assertThat(false, `is`(result))
    }

    @Test
    fun isValidateDetails_valid_email_and_blank_password_returnsFalse() {
        val email = "abc.com"
        val password =""

        val result = loginPresenterImpl.isValidDetails(email, password)

        assertThat(false, `is`(result))
    }

    @Test
    fun isValidateDetails_null_email_and_null_password_returnsFalse() {
        val email = null
        val password =null

        val result = loginPresenterImpl.isValidDetails(email, password)

        assertThat(false, `is`(result))
    }

    @Test
    fun isValidateDetails_valid_email_and_password_returnsTrue() {
        val email = "asd@gmail.com"
        val password ="asd@123"

        val result = loginPresenterImpl.isValidDetails(email, password)

        assertThat(true, `is`(result))
    }

    @Test
    fun isValidateDetails_valid_email_with_sub_domain_and_password_returnsTrue() {
        val email = "asd@gmail.co.in"
        val password ="asd@123"

        val result = loginPresenterImpl.isValidDetails(email, password)

        assertThat(true, `is`(result))
    }
}
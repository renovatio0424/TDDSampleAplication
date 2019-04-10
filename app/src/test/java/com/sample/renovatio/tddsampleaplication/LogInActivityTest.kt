package com.sample.renovatio.tddsampleaplication

import android.text.Editable
import android.widget.Button
import android.widget.EditText
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LogInActivityTest {

    @Spy
    lateinit var logInActivity: LogInActivity

    @Mock
    lateinit var emailEditText: EditText

    @Mock
    lateinit var passwordEditText: EditText

    @Mock
    lateinit var loginButton: Button

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)

        Mockito.doReturn(emailEditText).`when`(logInActivity).findViewById<EditText>(R.id.et_email)
        Mockito.doReturn(passwordEditText).`when`(logInActivity).findViewById<EditText>(R.id.et_password)
        Mockito.doReturn(loginButton).`when`(logInActivity).findViewById<Button>(R.id.but_login)
    }

    @Test
    fun `잘못된 이메일주소를 입력하고 로그인했을 경우`() {
        //given
        val emailError = ErrorType.INVALID_EMAIL
        //when
        logInActivity.showErrorMessage(emailError)

    }

    @Test
    fun `잘못된 비밀번호를 입력하고 로그인 버튼을 눌렀을 경우`() {
        val passwordError = ErrorType.INVALID_PASSWORD
        logInActivity.showErrorMessage(passwordError)
    }

    @Test
    fun `로그인 실패시`(){
        val loginFailed = ErrorType.FAILED_LOGIN
        logInActivity.showErrorMessage(loginFailed)
    }

    @Test
    fun `로그인 성공시`(){
        logInActivity.showSuccessMessage()
    }

}
package com.sample.renovatio.tddsampleaplication

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LogInPresenterTest {
    @Mock
    lateinit var logInActivity: LogInActivity

    @Mock
    lateinit var logInRepository: LogInRepository

    lateinit var logInPresenter: LogInPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        logInPresenter = LogInPresenter(logInActivity, logInRepository)
    }

    @Test
    fun `이메일 양식이 맞지 않는 경우`() {
        //given
        val failedEmailPattern = "reno.kim*email.com"
        //when
        val isSuccess = logInPresenter.isValidEmail(failedEmailPattern)
        //then
        Assert.assertEquals(false, isSuccess)
    }

    @Test
    fun `비밀번호 양식이 맞지 않는 경우`() {
        //given
        val failedPasswordPattern = "1234"
        //when
        val isSuccess = logInPresenter.isValidPassword(failedPasswordPattern.toInt())
        //then
        Assert.assertEquals(false, isSuccess)
    }

    @Test
    fun `정상적으로 로그인이 되었을 경우`() {
        //given
        val email = "reno.kim@kinemaster.com"
        val password = 123456789
        //when
        logInPresenter.login(email, password)
//        //then
//        Assert.
    }

    @Test
    fun `로그인에 실패했을 경우`() {
        //given
        //when
        //then
    }
}
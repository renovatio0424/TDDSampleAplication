package com.sample.renovatio.tddsampleaplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class LogInActivity : AppCompatActivity(), LogInContract.View {

    private val presenter by lazy {
        LogInPresenter(this, LogInRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        but_login.setOnClickListener {
            when{
                !presenter.isValidEmail(et_email.text.toString()) -> showErrorMessage(ErrorType.INVALID_EMAIL)
                !presenter.isValidPassword(et_password.text.toString().toInt()) -> showErrorMessage(ErrorType.INVALID_PASSWORD)
                else -> presenter.login(et_email.text.toString(), et_password.text.toString().toInt())
            }
        }
    }

    override fun showErrorMessage(error: ErrorType) {
        when(error){
            ErrorType.INVALID_EMAIL -> toast(" invalid email patter")
            ErrorType.INVALID_PASSWORD -> toast("invalid password pattern")
            ErrorType.FAILED_LOGIN -> toast("failed Email")
        }
    }

    override fun showSuccessMessage() {
        toast("login success!!")
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dismissLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

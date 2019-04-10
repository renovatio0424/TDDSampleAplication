package com.sample.renovatio.tddsampleaplication

import java.util.regex.Pattern

class LogInPresenter(val view: LogInContract.View, val repository: LogInRepository) : LogInContract.Presenter {

    override fun isValidEmail(email: String): Boolean {
        return Pattern.matches(
            "[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+",
            email.trim())
    }

    override fun isValidPassword(password: Int): Boolean {
        return password.toString().length > 5
    }

    override fun login(email: String, password: Int) {
        if(repository.myEmail == email && repository.myPassword.toInt() == password)
            view.showSuccessMessage()
        else
            view.showErrorMessage(ErrorType.FAILED_LOGIN)
    }

}
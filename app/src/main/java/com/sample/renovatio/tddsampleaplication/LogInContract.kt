package com.sample.renovatio.tddsampleaplication

class LogInContract {
    interface View {
        fun showErrorMessage(error:ErrorType)
        fun showSuccessMessage()
        fun showLoading()
        fun dismissLoading()
    }

    interface Presenter {
        fun isValidEmail(email: String): Boolean
        fun isValidPassword(password: Int): Boolean
        fun login(email: String, password: Int)
    }
}
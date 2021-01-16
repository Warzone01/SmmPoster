package com.kirdevelopment.smmposter.presenters

import android.os.Handler
import com.kirdevelopment.smmposter.views.LoginView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class LoginPresenter: MvpPresenter<LoginView>() {
    fun login(isSuccess: Boolean){
        viewState.startLoading()
        Handler().postDelayed({
            viewState.endLoading()
            if (isSuccess){
                viewState.openPosts()
            }else {
                viewState.showError("Login Data Incorrect")
            }
        }, 2000)
    }
}
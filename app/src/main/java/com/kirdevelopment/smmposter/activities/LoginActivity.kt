package com.kirdevelopment.smmposter.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import com.github.rahatarmanahmed.cpv.CircularProgressView
import com.kirdevelopment.smmposter.R
import com.kirdevelopment.smmposter.presenters.LoginPresenter
import com.kirdevelopment.smmposter.views.LoginView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class LoginActivity : MvpAppCompatActivity(), LoginView {
    private lateinit var mBtnLogin: FrameLayout
    private lateinit var mCPV: CircularProgressView

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtnLogin = findViewById(R.id.loginButtonLayout)
        mCPV = findViewById(R.id.loginProgressCPV)

        mBtnLogin.setOnClickListener{
            loginPresenter.login(true)
        }
    }

    override fun startLoading() {
        mCPV.visibility = View.VISIBLE
        mBtnLogin.visibility = View.GONE
    }

    override fun endLoading() {
        mCPV.visibility = View.GONE
        mBtnLogin.visibility = View.VISIBLE
    }

    override fun showError(string: String) {
        Toast.makeText(this, "$string", Toast.LENGTH_SHORT).show()
    }

    override fun openPosts() {
        startActivity(Intent(this, ShowPostActivity::class.java))
        endLoading()
        finish()
    }
}
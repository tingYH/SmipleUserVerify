package com.example.chengkaidemo.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chengkaidemo.R
import com.example.chengkaidemo.data.db.entities.User
import com.example.chengkaidemo.databinding.ActivitySignupBinding
import com.example.chengkaidemo.ui.home.HomeActivity
import com.example.chengkaidemo.utils.hide
import com.example.chengkaidemo.utils.show
import com.example.chengkaidemo.utils.snackbar
import kotlinx.android.synthetic.main.activity_login.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SignupActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val factory: AuthViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivitySignupBinding>(this, R.layout.activity_signup)
        val viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)

//        viewModel.getLoggedInUser().observe(this, Observer { user ->
//            if (user != null) {
//                intent = Intent(this, HomeActivity::class.java).also {
//                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                    startActivity(intent)
//                }
//            }
//        })
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()

//        root_layout.snackbar("${user.name} is logged in")
//        toast("${user.name} is logged in")
//        loginResponse.observe(this, Observer {
//            progress_bar.hide()
//            toast(it)
//        })
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
//        toast(message)
    }
}
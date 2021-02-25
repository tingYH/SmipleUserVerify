package com.example.chengkaidemo.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.chengkaidemo.R
import com.example.chengkaidemo.databinding.ActivityLoginBinding
import com.example.chengkaidemo.ui.home.HomeActivity
import com.example.chengkaidemo.utils.ApiException
import com.example.chengkaidemo.utils.NoInternetException
import com.example.chengkaidemo.utils.snackbar
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), KodeinAware {
    override val kodein by kodein()
    private val factory: AuthViewModelFactory by instance()

    private lateinit var viewModel: AuthViewModel
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val networkConnectionInterceptor = NetworkConnectionInterceptor(this)
//        val api = MyApi(networkConnectionInterceptor)
//        val db = AppDatabase(this)
//        val repository = UserRepository(api, db)
//        val factory = AuthViewModelFactory(repository)
        binding =
            DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)

        viewModel.getLoggedInUser().observe(this, Observer { user ->
            if (user != null) {
                intent = Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            }
        })

        binding.buttonSignIn.setOnClickListener {
            loginUser()
        }
        binding.textViewSignUp.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }

    private fun loginUser() {
        val email = binding.editTextEmail.text.toString().trim()
        val password = binding.editTextPassword.text.toString().trim()
        //todo add validation
        lifecycleScope.launch {
            try {
                val authResponse = viewModel.userLogin(email, password)
                if (authResponse.user != null) {
                    viewModel.saveLoggedInUser(authResponse.user!!)
                } else {
                    binding.rootLayout.snackbar(authResponse.message!!)
                }
            } catch (e: ApiException) {
                binding.rootLayout.snackbar(e.message!!)
            } catch (e: NoInternetException) {
                binding.rootLayout.snackbar(e.message!!)
            }
        }


    }

//    override fun onStarted() {
//        progress_bar.show()
//    }
//
//    override fun onSuccess(user: User) {
//        progress_bar.hide()
//
////        root_layout.snackbar("${user.name} is logged in")
////        toast("${user.name} is logged in")
////        loginResponse.observe(this, Observer {
////            progress_bar.hide()
////            toast(it)
////        })
//    }
//
//    override fun onFailure(message: String) {
//        progress_bar.hide()
//        root_layout.snackbar(message)
////        toast(message)
//    }
}
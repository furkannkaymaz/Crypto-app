package com.cryptoApp.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.cryptoApp.R
import com.cryptoApp.base.BaseFragment
import com.cryptoApp.databinding.FragmentLoginBinding
import com.cryptoApp.utils.extensions.toast
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    override val viewModel by viewModels<LoginViewModel>()
    private lateinit var navController : NavController

    override fun onCreateFinished() {
        navController = Navigation.findNavController(requireActivity(), R.id.main)
        binding?.contentTop?.setText("Crypto",requireActivity())
    }

    override fun clickListeners() {
        super.clickListeners()
        binding?.btnSignIn?.setOnClickListener {
            navController.navigate(
                R.id.action_loginFragment_to_singInFragment,
            )
        }
        binding?.btnLogIn?.setOnClickListener {
        loginValidation(
            binding?.etUsername?.text.toString(),
            binding?.etPassword?.text.toString(),
        )
        }
    }

    private fun loginValidation(email: String, password: String) {
        val emailControl = email.trim { it <= ' ' }
        val passwordControl = password.trim { it <= ' ' }

        if (email.isNotEmpty() && password.isNotEmpty()){
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(emailControl, passwordControl)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        context?.toast("Giriş Başarılı")
                        navController.navigate(
                            R.id.action_loginFragment_to_fragmentMain,
                        )
                    } else
                        Toast.makeText(
                            context,
                            task.exception!!.message.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                }
        }else{
            context?.toast("Lütfen tüm alanları doldurun")
        }

    }

    override fun layoutResource(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

}
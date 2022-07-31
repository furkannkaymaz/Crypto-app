package com.cryptoApp.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.cryptoApp.R
import com.cryptoApp.base.BaseFragment
import com.cryptoApp.databinding.FragmentSingInBinding
import com.cryptoApp.utils.extensions.toast
import com.google.firebase.auth.FirebaseAuth

class SingInFragment : BaseFragment<FragmentSingInBinding,SignInViewModel>() {

    private lateinit var navController: NavController

    override val viewModel by viewModels<SignInViewModel>()

    override fun onCreateFinished() {
        navController = Navigation.findNavController(requireActivity(), R.id.main)
        binding?.contentTop?.setText("Crypto",requireActivity())

    }
    override fun clickListeners() {
        super.clickListeners()

        binding?.btnSignIn?.setOnClickListener {
            registerValidation(
                binding?.etUsername?.text.toString(),
                binding?.etPassword?.text.toString(),
                binding?.etRePassword?.text.toString(),
            )
        }

        binding?.ivBack?.setOnClickListener {
            navController.navigate(
                R.id.action_singInFragment_to_loginFragment,
            )
        }
    }

    override fun layoutResource(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSingInBinding {
        return FragmentSingInBinding.inflate(inflater, container, false)
    }

    private fun registerValidation(email: String, password: String, repassword: String) {

        val emailControl = email.trim { it <= ' ' }
        val passwordControl = password.trim { it <= ' ' }
        val rePasswordControl = repassword.trim { it <= ' ' }

        if (email.isNotEmpty() && password.isNotEmpty() && repassword.isNotEmpty()){
            if (passwordControl != rePasswordControl)
            context?.toast("Şifreler eşleşmiyor")
            else {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(emailControl, passwordControl)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            context?.toast("Kayıt Başarılı")
                            navController.navigate(
                                R.id.action_singInFragment_to_loginFragment,
                            )
                        } else
                            context?.toast(task.exception?.message.toString())
                    }
            }
        }else{
            context?.toast("Lütfen tüm alanları doldurun")
        }

    }

}
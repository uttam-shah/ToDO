package com.example.todo.login_reg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.todo.R
import com.example.todo.databinding.FragmentSignup2Binding
import com.example.todo.databinding.FragmentSignupOtpBinding
import com.example.todo.login_reg.view_models.SignupViewModel

class SignupOtpFragment : Fragment() {

    private lateinit var viewModel: SignupViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSignupOtpBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_signup_otp, container, false
        )

        viewModel = ViewModelProvider(requireActivity()).get(SignupViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

}
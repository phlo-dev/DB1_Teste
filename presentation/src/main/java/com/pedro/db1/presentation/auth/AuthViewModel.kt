package com.pedro.db1.presentation.auth

import androidx.lifecycle.ViewModel
import com.pedro.db1.domain.usecase.login.AuthenticationUseCase

class AuthViewModel(private val authUseCase: AuthenticationUseCase) : ViewModel()
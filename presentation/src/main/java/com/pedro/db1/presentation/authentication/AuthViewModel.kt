package com.pedro.db1.presentation.authentication

import androidx.lifecycle.ViewModel
import com.pedro.db1.domain.usecase.login.SignInUseCase
import com.pedro.db1.presentation.createViewState

class AuthViewModel(private val authUseCase: SignInUseCase) : ViewModel(){
    private val authViewState = createViewState<Unit>()
}
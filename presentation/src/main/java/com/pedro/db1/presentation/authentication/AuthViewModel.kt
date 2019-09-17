@file:Suppress("MemberVisibilityCanBePrivate")

package com.pedro.db1.presentation.authentication

import androidx.core.util.PatternsCompat
import androidx.lifecycle.*
import com.pedro.db1.domain.model.AuthenticationParam
import com.pedro.db1.domain.usecase.login.SignInUseCase
import com.pedro.db1.presentation.*
import com.pedro.db1.presentation.utils.FieldState
import com.pedro.db1.presentation.utils.FieldState.*
import com.pedro.db1.presentation.utils.useCase
import org.koin.standalone.KoinComponent

class AuthViewModel : ViewModel(), LifecycleObserver, KoinComponent {
    private val authViewState = createViewState<Unit>()
    private val emailState = createFieldState()
    private val passwordState = createFieldState()
    private val authUseCase: SignInUseCase by useCase()

    fun validateFields(email: String, password: String) {
        if (emailState.validateEmail(email) && emailState.validatePassword(password)) {
            signIn(email, password)
        }
    }

    fun MutableLiveData<FieldState>.validateEmail(email: String): Boolean {
        val isEmail = PatternsCompat.EMAIL_ADDRESS.toRegex().matches(email)
        when {
            email.isBlank() -> postValue(EMPTY)
            isEmail -> {
                postValue(VALID); return isEmail
            }
            else -> postValue(INVALID)
        }
        return false
    }

    fun MutableLiveData<FieldState>.validatePassword(password: String): Boolean {
        when {
            password.isBlank() -> postValue(EMPTY)
            password.length >= 6 -> {
                postValue(VALID); return true
            }
            else -> postValue(INVALID)
        }
        return false
    }

    private fun signIn(email: String, password: String) {
        authUseCase.execute(
            params = AuthenticationParam(userEmail = email, userPassword = password),
            onSuccess = { authViewState.postSuccess(it) },
            onFailure = { authViewState.postFailure(it) }
        )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun stopWorkOnStop() {
        emailState.postValue(NEUTRAL)
        passwordState.postValue(NEUTRAL)
        authViewState.postNeutral()
        authUseCase.cancel()
    }

    fun getAuthViewState() = authViewState.asLiveData()

    override fun onCleared() {
        authUseCase.cancel()
        super.onCleared()
    }
}
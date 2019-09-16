package com.pedro.db1.dependencies

import com.pedro.db1.presentation.authentication.AuthViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val presentationModule = module {
    //Authentication View Model
    viewModel { AuthViewModel(authUseCase = get()) }

}
package com.pedro.db1.teste.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.pedro.db1.teste.R

class MainActivity : AppCompatActivity() {
    private val navController by lazy { findNavController(R.id.navHostMain) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}

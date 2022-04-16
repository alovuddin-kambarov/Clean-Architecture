package com.example.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.utils.UserResource
import com.example.cleanarchitecture.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: UserViewModel by viewModels { factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch{

            viewModel.getUsers().collect{

                when(it){
                    is UserResource.Error -> {
                        println("alovuddin: ${it.message}")
                    }
                    UserResource.Loading -> {
                        println("alovuddin: loading...")
                    }
                    is UserResource.Success -> {
                        println("alovuddin: ${it.list}")
                    }
                }


            }
        }

    }
}
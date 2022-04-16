package com.example.cleanarchitecture.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.utils.UserResource
import com.example.domain.models.interactor.UserInteract
import com.example.domain.models.models.Cocktail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userInteract: UserInteract) : ViewModel() {

    fun getUsers(): StateFlow<UserResource> {
        val stateFlow = MutableStateFlow<UserResource>(UserResource.Loading)
        viewModelScope.launch {
            userInteract.getUsers().catch {
                stateFlow.emit(UserResource.Error(it.message ?: "Error"))
            }
                .collect {
                    if (it.isSuccess) {
                        stateFlow.emit(UserResource.Success(it.getOrNull()!!))
                    } else if (it.isFailure) {
                        stateFlow.emit(UserResource.Error(it.exceptionOrNull().toString()))
                    }
                }
        }

        return stateFlow
    }

}
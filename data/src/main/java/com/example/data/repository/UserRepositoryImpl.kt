package com.example.data.repository

import com.example.data.network.ApiService
import com.example.domain.models.models.Cocktail
import com.example.domain.models.models.CocktailList
import com.example.domain.models.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(var apiService: ApiService) : UserRepository {

    override fun getUsers(): Flow<CocktailList> {
       return apiService.getCocktailByName("all")!!
    }

}
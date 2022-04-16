package com.example.domain.models.repository

import com.example.domain.models.models.CocktailList
import kotlinx.coroutines.flow.Flow


interface UserRepository {

    fun getUsers(): Flow<CocktailList>

}
package com.example.domain.models.interactor

import com.example.domain.models.models.Cocktail
import com.example.domain.models.models.CocktailList
import com.example.domain.models.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserInteract @Inject constructor(private val userRepository: UserRepository) {

    fun getUsers(): Flow<Result<CocktailList>> {
        return userRepository.getUsers()
            .map {
                Result.success(it)
            }
            .catch {
                emit(Result.failure(it))
            }
            .flowOn(Dispatchers.IO)
    }

}
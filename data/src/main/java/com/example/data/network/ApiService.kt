package com.example.data.network

import com.example.domain.models.models.CocktailList
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search.php")
     fun getCocktailByName(@Query(value = "s") tragoName: String): Flow<CocktailList>?

}
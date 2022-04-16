package com.example.domain.models.models

import com.google.gson.annotations.SerializedName

data class CocktailList(
    @SerializedName("drinks")
    val cocktailList: List<Cocktail> = listOf()
)
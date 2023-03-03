package com.example.testingexampleshoppinglist.repositories

import androidx.lifecycle.LiveData
import com.example.testingexampleshoppinglist.data.local.ShoppingItem
import com.example.testingexampleshoppinglist.data.remote.responses.UnsplashResponse
import com.example.testingexampleshoppinglist.other.Resource

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observerTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<UnsplashResponse>

}
package com.example.testingexampleshoppinglist.di

import android.content.Context
import androidx.room.Room
import com.example.testingexampleshoppinglist.data.local.ShoppingDao
import com.example.testingexampleshoppinglist.data.local.ShoppingItemDatabase
import com.example.testingexampleshoppinglist.data.remote.UnsplashApi
import com.example.testingexampleshoppinglist.data.remote.UnsplashApi.Companion.BASE_URL
import com.example.testingexampleshoppinglist.other.Constants.DATABASE_NAME
import com.example.testingexampleshoppinglist.repositories.DefaultShoppingRepository
import com.example.testingexampleshoppinglist.repositories.ShoppingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideShoppingItemDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, ShoppingItemDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDefaultShoppingRepository(
        dao: ShoppingDao,
        api: UnsplashApi
    ) = DefaultShoppingRepository(dao, api) as ShoppingRepository

    @Singleton
    @Provides
    fun provideShoppingDao(
        database: ShoppingItemDatabase
    ) = database.shoppingDao()

    @Singleton
    @Provides
    fun provideUnsplashApi(): UnsplashApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(UnsplashApi::class.java)
    }
}
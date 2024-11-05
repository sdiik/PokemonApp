package com.example.myapplication.data.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.dao.PokemonDao
import com.example.myapplication.data.dao.PokemonDatabase
import com.example.myapplication.data.repository.OfflinePokemonRepositoryImp
import com.example.myapplication.data.repository.Repository
import com.example.myapplication.data.repository.RepositoryImp
import com.example.myapplication.data.service.ApiService
import com.example.myapplication.data.service.Constants
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

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun providePokemonRepository(apiService: ApiService): Repository = RepositoryImp(apiService)

    @Provides
    @Singleton
    fun providePokemonDatabase(@ApplicationContext context: Context): PokemonDatabase {
        return Room.databaseBuilder(
            context, PokemonDatabase::class.java, "item_database"
        ).build()
    }

    @Provides
    @Singleton
    fun providePokemonDeo(database: PokemonDatabase): PokemonDao {
        return database.pokemonDeo()
    }

    @Provides
    @Singleton
    fun provideOfflinePokemonRepository(pokemonFavoriteDao: PokemonDao): OfflinePokemonRepositoryImp {
        return OfflinePokemonRepositoryImp(pokemonFavoriteDao)
    }

}
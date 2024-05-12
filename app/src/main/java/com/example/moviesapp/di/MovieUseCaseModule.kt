package com.example.moviesapp.di

import com.example.moviesapp.data.repository.MovieRepositoryImpl
import com.example.moviesapp.domain.usecase.GetMovieUseCase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MovieUseCaseModule {
    fun getMovie(movieRepositoryImpl: MovieRepositoryImpl):GetMovieUseCase{
     return GetMovieUseCase(movieRepositoryImpl)
    }
}

package com.example.moviesapp.di

import com.example.moviesapp.data.FakeRemoteDataSource
import com.example.moviesapp.data.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MovieRepositoryModule  {
    @Provides
    @Singleton
    fun getMovieRepository(fakeRemoteDataSource: FakeRemoteDataSource):MovieRepositoryImpl{
          return MovieRepositoryImpl(fakeRemoteDataSource)
    }
}
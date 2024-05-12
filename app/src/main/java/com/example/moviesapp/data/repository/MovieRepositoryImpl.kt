package com.example.moviesapp.data.repository

import com.example.moviesapp.data.FakeRemoteDataSource
import com.example.moviesapp.domain.entity.Movie
import com.example.moviesapp.domain.repo.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val fakeRemoteDataSource: FakeRemoteDataSource):MovieRepository {
    override fun getMovieById(id: Int):Movie= fakeRemoteDataSource.getMovieById(id)!!
    override fun getImage(id: Int): Int=fakeRemoteDataSource.getImage(id)!!


}
package com.example.moviesapp.domain.repo

import com.example.moviesapp.data.FakeRemoteDataSource
import com.example.moviesapp.domain.entity.Movie
import javax.inject.Inject

interface MovieRepository  {
    fun getMovieById(id:Int):Movie
    fun getImage(id: Int):Int
}
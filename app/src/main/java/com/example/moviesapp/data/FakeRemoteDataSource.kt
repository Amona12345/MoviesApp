package com.example.moviesapp.data

import com.example.moviesapp.domain.entity.Movie
import javax.inject.Inject

class FakeRemoteDataSource @Inject constructor() {
    fun getAllMovie(): List<Movie> {
        return movies
    }
    fun getMovieById(id:Int):Movie?{
        return movies.find { it.id==id }
    }
    fun getImage(id: Int):Int?{
        return images.get(id)

    }
}
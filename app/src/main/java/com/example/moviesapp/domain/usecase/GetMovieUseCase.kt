package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.images
import com.example.moviesapp.data.repository.MovieRepositoryImpl
import javax.inject.Inject

class GetMovieUseCase@Inject constructor(private val movieRepositoryImpl: MovieRepositoryImpl)
   {
      fun getName()=movieRepositoryImpl.getMovieById(2)
    //  fun  getImage() = movieRepositoryImpl.getMovieById(images.get(1))
   }




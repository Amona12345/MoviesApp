package com.example.moviesapp.presentation.model

import androidx.lifecycle.ViewModel
import com.example.moviesapp.domain.usecase.GetMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MovieVewModel @Inject constructor(private val getMovieUseCase: GetMovieUseCase):ViewModel() {
    private val _state=MutableStateFlow(MovieUiState())
    val state=_state.asStateFlow()
    init{
        getMovieName()
       //  getMovieImage()
    }
    fun getMovieName(){
        _state.update {
          it.copy(
              moviename =  getMovieUseCase.getName()?.movie_name?:"N/A"
          )
        }
    }
//    fun getMovieImage(){
//        _state.update {
//            it.copy(
//                imageUrl = getMovieUseCase.getImage().poster_image
//            )
//        }
//    }
}
data class MovieUiState(
    var moviename:String?=null,
    val id:Int?=null,
    val imageUrl:Int?=null
)
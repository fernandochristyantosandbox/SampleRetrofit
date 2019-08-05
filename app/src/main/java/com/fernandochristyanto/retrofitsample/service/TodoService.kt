package com.fernandochristyanto.retrofitsample.service

import com.fernandochristyanto.retrofitsample.model.Todo
import retrofit2.Call
import retrofit2.http.GET

public interface TodoService{
    @GET("todos") // baseurl/todos
    fun todos(): Call<List<Todo>>
}
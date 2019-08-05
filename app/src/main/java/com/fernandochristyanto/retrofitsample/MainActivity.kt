package com.fernandochristyanto.retrofitsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fernandochristyanto.retrofitsample.config.NetworkUtil
import com.fernandochristyanto.retrofitsample.model.Todo
import com.fernandochristyanto.retrofitsample.service.TodoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var todoService: TodoService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoService = NetworkUtil.getRetrofit().create(TodoService::class.java)
        val todosCall = todoService.todos()
        /**
         * Enqueing directly in activity is not recommended though, this is just for convenience
         */
        todosCall.enqueue(object: Callback<List<Todo>> {
            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                Log.d("RetrofitError", t.message)
            }

            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                Log.d("RetrofitResponse", response.body()?.size.toString()) // Size of todos arr
            }

        })
    }
}

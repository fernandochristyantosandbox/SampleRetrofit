package com.fernandochristyanto.retrofitsample.config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtil {
    companion object{
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(RetrofitConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
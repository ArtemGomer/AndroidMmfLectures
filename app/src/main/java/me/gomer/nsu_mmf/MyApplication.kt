package me.gomer.nsu_mmf

import android.app.Application
import me.gomer.nsu_mmf.network.MyInterceptor
import me.gomer.nsu_mmf.network.NumberApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {

    val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .addInterceptor(MyInterceptor())
        .build()

    val numberApi = Retrofit.Builder()
        .client(client)
        .baseUrl("http://numbersapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NumberApi::class.java)
}
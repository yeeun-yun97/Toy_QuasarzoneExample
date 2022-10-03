package com.github.yeeun_yun97.toy.quasarzoneexample

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface QuarsarzoneApi {
    companion object{
        private const val BASE_URL = "https://quasarzone.com/"
        private lateinit var service: QuarsarzoneApi

        fun getInstance(): QuarsarzoneApi {
            if (!this::service.isInitialized) {
                service = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(QuarsarzoneApi::class.java)
            }
            return service
        }
    }

    @Headers("Content-Type: application/json")
    @GET("/bbs/qb_saleinfo")
    fun getData(@Query("page")  page : Int): Call<ResponseBody>

}
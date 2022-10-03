package com.github.yeeun_yun97.toy.quasarzoneexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView : TextView = findViewById(R.id.tv)

        QuarsarzoneApi.getInstance().getData(1).enqueue(object: Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                textView.setText(response.body()!!.string())
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("on failure", "실패함, 메시지 = ${t.message}")
            }

        })
    }
}
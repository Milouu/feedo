package com.example.feedo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.feedo.offApi.OffClient
import com.example.feedo.offApi.Product
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val offClient = OffClient()

        val productId = 3029330003533

        val request = offClient.api.getProductById(productId)
        request.enqueue(object : retrofit2.Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if(response.isSuccessful) {
                    val product = response.body()!!
                    Log.d("PRODUCT_NAME", product.generic_name_fr)
                    textView.text = product.generic_name_fr
                } else {
                    Toast.makeText(applicationContext, "HTTP CODE ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Toast.makeText(applicationContext, "ERROR", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

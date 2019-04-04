package com.example.feedo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.feedo.modelApi.OffWrapper
import com.example.feedo.offApi.OffClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_singleproduct.*

class SingleProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singleproduct)

        val offClient = OffClient()

        val productId = 3029330003533

        val request = offClient.api.getProductById(productId)
        request.enqueue(object : Callback<OffWrapper> {

            override fun onResponse(call: Call<OffWrapper>, response: Response<OffWrapper>) {
                if(response.isSuccessful) {
                    val wrapper = response.body()!!
                    Log.d("PRODUCT_NAME", "WORKS")
                    productName.text = "${wrapper.product.generic_name_fr}"
                } else {
                    Toast.makeText(this@SingleProductActivity, "HTTP CODE ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<OffWrapper>, t: Throwable) {
                Toast.makeText(this@SingleProductActivity, "ERROR", Toast.LENGTH_SHORT).show()
                Log.d("PRODUCT", "Failure")
            }
        })
    }
}
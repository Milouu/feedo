package com.example.feedo

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Window
import android.widget.Toast
import com.example.feedo.modelApi.OffWrapper
import com.example.feedo.offApi.OffClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_singleproduct.*

class SingleProductActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_singleproduct)

        val offClient = OffClient()

        val productCat = "riz"

        val request = offClient.api.getProductByCategory(productCat)
        request.enqueue(object : Callback<OffWrapper> {

            override fun onResponse(call: Call<OffWrapper>, response: Response<OffWrapper>) {
                if(response.isSuccessful) {
                    Log.d("PRODUCT_NAME", "WORKS")

                    val wrapper = response.body()!!
                    val product = wrapper.products[0]

                    productName.text = "${product.generic_name_fr}"
                    brandName.text = "${product.brands[0]}"
                    quantityNumb.text= "${product.quantity}"
                    calories.text = "${product.nutriments.energy} kcal"
                    proteines.text = "${product.nutriments.proteins} g"
                    sucres.text = "${product.nutriments.sugars} g"

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
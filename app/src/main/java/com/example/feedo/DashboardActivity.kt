package com.example.feedo

import android.app.Activity
import android.os.Bundle
import android.view.Window

class DashboardActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_dashboard)


    }
}
package com.example.feedo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : Activity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_dashboard)

        readInDatabase()

        val profil = findViewById<LinearLayout>(R.id.profil)
        profil.setOnClickListener(this)

        val feculent = findViewById<LinearLayout>(R.id.feculent)
        feculent.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.profil -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }

            R.id.feculent -> {
                val intent = Intent(this, SingleProductActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        }

    }

    private fun readInDatabase() {

        val ref = FirebaseDatabase.getInstance().reference
        val profilId = "googleId"
        val refUid = ref.child("Profils").child(profilId)


        val name: TextView = findViewById(R.id.nameUser)

        val valueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(Profil::class.java)
                name.text = value?.name
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.d("error", databaseError.message) //Don't ignore errors!
            }
        }
        refUid.addListenerForSingleValueEvent(valueEventListener)
    }
}
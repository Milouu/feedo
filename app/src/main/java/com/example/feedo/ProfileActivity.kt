package com.example.feedo

import android.app.Activity
import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener






class ProfileActivity : Activity() {

   // lateinit var ref : DatabaseReference
   // lateinit var profilId : String
   private val TAG = "MyMessage"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_profile)




        readInDatabase()



    }



    private fun readInDatabase() {

        val ref = FirebaseDatabase.getInstance().reference
      //  val profilId = FirebaseAuth.getInstance().currentUser!!.uid
        val profilId = "googleId"
        val refUid = ref.child("Profils").child(profilId)


        val name:TextView = findViewById(R.id.nameUser)
        val objectif:TextView = findViewById(R.id.objectifText)
        val age:TextView = findViewById(R.id.ageText)
        val weight:TextView = findViewById(R.id.weightText)
        val size:TextView = findViewById(R.id.sizeText)
        val valueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(Profil::class.java)
                Log.d(TAG,value!!.name);
                name.text = value.name
                objectif.text = value.objectif
                age.text = value.age.toString() + " ans"
                weight.text = value.weight.toString() + " kg"
                size.text = value.size.toString() + " cm"
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.d(TAG, databaseError.message) //Don't ignore errors!
            }
        }
        refUid.addListenerForSingleValueEvent(valueEventListener)


    }

}

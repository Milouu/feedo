package com.example.feedo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_form.*


// lateinit var editWeight: EditText
// lateinit var buttonSend: Button




class FormActivity : AppCompatActivity() {


    private lateinit var spinnerGender: Spinner
    private lateinit var spinnerSport: Spinner
    private lateinit var spinnerObjectif: Spinner
    lateinit var genderResult: String
    lateinit var sportResult: String
    lateinit var objectifResult: String



    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, FormActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        //setupUI()

      //  editWeight = findViewById(R.id.editWeight)
       // buttonSend= findViewById(R.id.buttonSendValue)





        //spinnerGender

        spinnerGender = findViewById(R.id.spinnerGender) as Spinner
        val genders = arrayOf("Femme", "Homme")

        spinnerGender.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,genders)

        spinnerGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                genderResult = genders.get(position)
            }
        }


        //spinnerSport

        spinnerSport = findViewById(R.id.spinnerSport) as Spinner
        val frequences = arrayOf("1","2","3","4","5")

        spinnerSport.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,frequences)

        spinnerSport.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                sportResult = frequences.get(position)
            }
        }

        //spinnerObjectif

        spinnerObjectif = findViewById(R.id.spinnerObjectif) as Spinner
        val objectifs = arrayOf("Perdre du poids","Prendre de la masse")

        spinnerObjectif.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,objectifs)

        spinnerObjectif.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                objectifResult = objectifs.get(position)
            }
        }


        buttonSend.setOnClickListener{
            saveValue()

        }

        //myRef.setValue("Hello, World!")
    }

    private fun saveValue(){
        //name
        val name = editName.text.toString().trim()
        if (name.isEmpty()){
            editName.error = "Please enter a name"
            return
        }

        // weight
        val valueWeight = editWeight.text.toString().trim()
        val weight = Integer.parseInt(valueWeight)
        if (weight.equals("")){
            editWeight.error = "Please enter a Weight"
            return
        }

        //age
        val valueAge = editAge.text.toString().trim()
        val age = Integer.parseInt(valueAge)

        if (age.equals("")){
            editAge.error = "Please enter an age"
            return
        }


        //size
        val valueSize = editSize.text.toString().trim()
        val size = Integer.parseInt(valueSize)

        if (size.equals("")){
            editSize.error = "Please enter an Size"
            return
        }

        val genderResult1 = genderResult
        val sportResult1 = Integer.parseInt(sportResult)

        // Write a message to the database
        val ref = FirebaseDatabase.getInstance().getReference("Profils")
        val profilId = FirebaseAuth.getInstance().currentUser?.uid ?: ref.push().key

        val currentProfil = Profil(name, weight,age,genderResult1,sportResult1,objectifResult,size,profilId)

        ref.child(profilId.toString()).setValue(currentProfil).addOnCompleteListener {
            Toast.makeText(applicationContext, "profil saved", Toast.LENGTH_LONG).show()

            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }





    }






}

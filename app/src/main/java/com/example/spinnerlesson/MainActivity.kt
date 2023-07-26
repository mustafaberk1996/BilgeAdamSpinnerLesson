package com.example.spinnerlesson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

//    private val fruits = listOf("Elma","Armut","Muz","Kiraz","Erik","Ananas")

    lateinit var spFruits:Spinner
    lateinit var spCars:Spinner
    lateinit var btnShowSelectedItem:Button

    companion object {
        const val CAR = "car"
        const val FRUIT = "fruit"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spFruits = findViewById(R.id.spFruits)
        spCars = findViewById(R.id.spCars)
        btnShowSelectedItem = findViewById(R.id.btnShowSelectedItem)

        spFruits.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Database.fruits.map { getString(it.name) })
        val carsPlateNoAndModelNames = Database.cars.map { "${it.model},${it.plateNo}" }
        spCars.adapter = ArrayAdapter(this,R.layout.tv_custom_spinner_item, carsPlateNoAndModelNames)


        btnShowSelectedItem.setOnClickListener {
            val selectedFruit = Database.fruits[spFruits.selectedItemPosition]
            //showAlert("Meyve Secimi","$selectedFruit meyvesi secildi.")

            val selectedCar = Database.cars[spCars.selectedItemPosition]
            showAlert(
                "Arac Secimi",
                "Secilen arac ${selectedCar.model}, plaka:${selectedCar.plateNo}, yakit tipi:${selectedCar.fuelType.name}"
            )

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(CAR, selectedCar)
            intent.putExtra(FRUIT, selectedFruit)
            startActivity(intent)
        }

        spFruits.onItemSelectedListener = object:OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedFruit = Database.fruits[position]
                showAlert("Meyve Secimi","$selectedFruit meyvesi secildi.")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity,"Bir secim yapilmadi",Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun showAlert(title:String, message:String, icon:Int = R.drawable.ic_launcher_background){
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .create().show()
    }



}
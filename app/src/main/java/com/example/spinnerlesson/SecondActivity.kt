package com.example.spinnerlesson

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var twCar:TextView
    lateinit var tvFruitName:TextView
    lateinit var ivFruit:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        twCar = findViewById(R.id.tw_car)
        tvFruitName=findViewById(R.id.tvFruitName)
        ivFruit=findViewById(R.id.ivFruit)
        val car = intent.getParcelableExtra<Car>(MainActivity.CAR)
        val fruit = intent.getParcelableExtra<Fruit>(MainActivity.FRUIT)

        car?.let {
            twCar.text = "${it.model} \n ${it.plateNo} \n ${it.fuelType}"
        }

        fruit?.let {
            //meyveyi ekranda goster
            tvFruitName.text = getString(it.name)
            tvFruitName.setTextColor(Color.parseColor(it.color))
            ivFruit.setImageResource(it.image)

        }

    }
}
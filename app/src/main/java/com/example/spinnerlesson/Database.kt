package com.example.spinnerlesson

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

object Database {

    val cars = listOf(
        Car(1,"BMW","34 TT 54",FuelType.DIESEL,14.0,60.0),
        Car(2,"Mercedes","3 AAA 1",FuelType.GASOLINE,30.0,50.0),
        Car(3,"Audi","24 IO 45",FuelType.DIESEL,20.0,40.0),
        Car(4,"Fiat","34 FF 100",FuelType.GAS,30.0,55.0),
        Car(5,"Hyundai","01 TE 90",FuelType.GASOLINE,13.4,60.0),
    )

    val fruits = listOf(
        Fruit(1,R.string.apple,R.drawable.apple, "#C51605"),
        Fruit(2,R.string.banana,R.drawable.banana,"#FFE17B"),
        Fruit(3,R.string.cherry,R.drawable.cherry,"#FE0000"),
        Fruit(4,R.string.pineapple,R.drawable.pineapple,"#FFB07F"),
        Fruit(5,R.string.pear,R.drawable.pear,"#1A5D1A")
    )
}

@Parcelize
data class Car(val id:Int, val model:String,val plateNo:String, val fuelType: FuelType,var currentFuelAmount:Double,val fuelCapacity:Double) :
    Parcelable

@Parcelize
data class Fruit(val id:Int,val name:Int, val image:Int, val color:String) : Parcelable

enum class FuelType(val price:Double){
    GAS(4.0),
    DIESEL(12.1),
    GASOLINE(15.5),
    ELECTRICAL(7.7)
}
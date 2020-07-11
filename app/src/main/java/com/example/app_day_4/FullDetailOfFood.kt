package com.example.app_day_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_full_detail_of_food.*

class FullDetailOfFood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_detail_of_food)
        val intent = intent
        val foodName : String = intent.getStringExtra("foodname")
        food_name.text = foodName
        val foodType : String = intent.getStringExtra("foodtype")
        food_type.text = foodType
        val foodDescription : String = intent.getStringExtra("fooddescription")
        food_description.text = foodDescription
        val foodImage : String = intent.getStringExtra("foodimage")
        Glide.with(this)
            .load(foodImage)
            .into(food_image)

    }
}
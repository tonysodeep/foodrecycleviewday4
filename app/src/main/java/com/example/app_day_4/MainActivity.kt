package com.example.app_day_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

private lateinit var linearLayoutManager: LinearLayoutManager
class MainActivity : OnItemClick,AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        food_rv.layoutManager = linearLayoutManager
        var foodAdapter : FoodAdapter = FoodAdapter(createFood(),this)
        foodAdapter.setFoodInterFace(this)
        food_rv.adapter = foodAdapter
        food_rv.setHasFixedSize(true)

    }
    fun createFood():ArrayList<Food>{
        var arrayFoodList = ArrayList<Food>()
        var food : Food
        for(i in 1..10){

            if(i % 2 == 0){
                food = Food("chili salar","america","this is food with caxi\n a\n f",
                    "https://www.huongnghiepaau.com/wp-content/uploads/2019/01/hoc-nau-an-mon-au.jpg")
                arrayFoodList.add(food)
            }
            else if (i % 3 == 0){
                food = Food("bun dau","asia","co mui mam tom\n era\n ef",
                    "https://thucthan.com/media/2018/06/bun-dau-mam-tom/cach-lam-bun-dau-mam-tom.jpg")
                arrayFoodList.add(food)
            }else{
                food = Food("firechicken","america","smell good tom\n era\n ef",
                    "https://cdn.tgdd.vn/Files/2018/05/28/1091506/cach-lam-ga-ran-vi-nhu-ga-kfc-sieu-ngon-cuc-de-lam-tai-nha.jpg")
                arrayFoodList.add(food)
            }

        }
        return arrayFoodList
    }

    override fun onFoodClick(food: Food) {
        val intent = Intent(this,FullDetailOfFood::class.java)
        intent.putExtra("foodname",food.name)
        intent.putExtra("foodtype",food.type)
        intent.putExtra("fooddescription",food.description)
        intent.putExtra("foodimage",food.image)
        startActivity(intent)
    }
}
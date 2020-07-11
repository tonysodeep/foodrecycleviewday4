package com.example.app_day_4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.america_food.view.*
import kotlinx.android.synthetic.main.asia_food.view.*

class FoodAdapter(private val foodList: List<Food>, val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var foodInterface : OnItemClick
    fun setFoodInterFace(foodinterface : OnItemClick){
        this.foodInterface = foodinterface
    }
    class AsiaFoodViewHolder(asiaItemView: View) : RecyclerView.ViewHolder(asiaItemView) {
        val asiafoodNameTextView: TextView = asiaItemView.tv_asfood_name
        val asiafoodDescripTextView: TextView = asiaItemView.tv_asfood_description
        val asiafoodImageView: ImageView = asiaItemView.iv_asfood_image
    }

    class AmericaFoodViewHolder(americaItemView: View) : RecyclerView.ViewHolder(americaItemView) {
        val americafoodNameTextView: TextView = americaItemView.tv_amfood_name
        val americafoodDescripTextView: TextView = americaItemView.tv_amfood_description
        val americafoodImageView: ImageView = americaItemView.iv_amfood_image
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var foodItemView: View
        if (viewType == 1) {
            foodItemView =
                LayoutInflater.from(parent.context).inflate(R.layout.asia_food, parent, false)
            return AsiaFoodViewHolder(foodItemView)
        } else {
            foodItemView =
                LayoutInflater.from(parent.context).inflate(R.layout.america_food, parent, false)
            return AmericaFoodViewHolder(foodItemView)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (foodList.get(position).type.equals("asia")) {
            return 1
        }
        return 2
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var currentItem = foodList[position]
        if (holder is AsiaFoodViewHolder) {
            var viewHolder: AsiaFoodViewHolder = holder
            viewHolder.asiafoodDescripTextView.text = currentItem.description
            viewHolder.asiafoodNameTextView.text = currentItem.name
            Glide.with(context)
                .load(currentItem.image)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(10, 1)))
                .into(holder.asiafoodImageView)
            viewHolder.asiafoodImageView.setOnClickListener{
                foodInterface.onFoodClick(currentItem)
            }
        } else if (holder is AmericaFoodViewHolder) {
            var viewHolder: AmericaFoodViewHolder = holder
            viewHolder.americafoodDescripTextView.text = currentItem.description
            viewHolder.americafoodNameTextView.text = currentItem.name
            Glide.with(context)
                .load(currentItem.image)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(10, 1)))
                .into(holder.americafoodImageView)
            viewHolder.americafoodImageView.setOnClickListener{
                foodInterface.onFoodClick(currentItem)
            }
        }
    }
}
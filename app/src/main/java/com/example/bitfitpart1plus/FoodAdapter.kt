package com.example.bitfitpart1plus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableRow
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfitpart1plus.R

const val FOOD_EXTRA = "FOOD_EXTRA"
private const val TAG = "FoodAdapter"
class FoodAdapter(private val context: Context, private val foods: List<DisplayFood>) :
RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.food_item,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = foods[position]
        holder.bind(food)
    }

    override fun getItemCount() = foods.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
    View.OnClickListener {
        private val foodNameTextView = itemView.findViewById<TextView>(R.id.foodNameTextView)
        private val numerofCalories = itemView.findViewById<TextView>(R.id.numberOfCalories)
        private val caloriesStringTextView = itemView.findViewById<TextView>(R.id.calories)
        val deleteButton = itemView.findViewById<Button>(R.id.deleteBtnItem)
        val comfirnDeletion = itemView.findViewById<Button>(R.id.confirmDelete)
//        val row = itemView.findViewById<TableRow>(R.id.foodListRV)


        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            deleteButton.visibility = View.VISIBLE
            val food = foods[absoluteAdapterPosition]
            deleteButton.setOnClickListener{
                val position: Int = absoluteAdapterPosition
                if(position != RecyclerView.NO_POSITION) {

                }


            }

//            val position: Int = absoluteAdapterPosition
//            if(position != RecyclerView.NO_POSITION) {
//
//                listerner.onItemClick(position)
//            }
//            deleteButton.setOnClickListener{
//                val intent2 = Intent(context, ConfirmDeleteActivity::class.java)
////            intent.putExtra(FOOD_EXTRA,food)
//                context.startActivity(intent2)
//            }

//            val food = foods[absoluteAdapterPosition]
//
////            addButton.setOnClickListener{
////                val intent = Intent(context,DetailsActivity::class.java)
//////                intent.putExtra(FOOD_EXTRA,food)
////                context.startActivity(intent)
////            }
//            val intent = Intent(context, DetailsActivity::class.java)
////            intent.putExtra(FOOD_EXTRA,food)
//            context.startActivity(intent)
        }



        fun bind(food: DisplayFood) {

            foodNameTextView.text = food.foodName
            numerofCalories.text = food.numOfCalories
//            caloriesStringTextView.text = food.caloriesString
        }
    }
//    interface onItemClickListener{
//        fun onItemClick(position: Int)
//    }
}
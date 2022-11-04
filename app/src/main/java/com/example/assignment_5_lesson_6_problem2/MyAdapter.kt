package com.example.assignment_5_lesson_6_problem2

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.InputStream


class MyAdapter(var context: Context,var products:ArrayList<Product>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.imageView.setImageResource(products.get(position).imageId)
        holder.price.text = "$" + products.get(position).price
        holder.color.text = products.get(position).color
        holder.imageView.setOnClickListener {
            val intent = Intent(context,DetailedActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("title", products.get(position).title)
            intent.putExtra("price", products.get(position).price)
            intent.putExtra("color", products.get(position).color)
            intent.putExtra("imageId", "" + products.get(position).imageId)
            intent.putExtra("itemid", products.get(position).itemid)
            intent.putExtra("desc", products.get(position).desc)
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return products.size
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView
        val price: TextView
        val color: TextView

        init {
            imageView = itemView.findViewById(R.id.imageView)
            price = itemView.findViewById(R.id.priceView)
            color = itemView.findViewById(R.id.colorView)
        }
    }
}
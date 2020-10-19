package com.example.kotlinrecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_item.view.*

class ExampleAdapter(private val exampleList: List<ExampleItem>) : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.example_item, parent, false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position];

        holder.imageView1.setImageResource(currentItem.imageResource)
        //holder.textView1.setText(currentItem.text1);
        holder.textView1.text = currentItem.text1 // other
        holder.textView2.setText(currentItem.text2)
    }

    override fun getItemCount(): Int = exampleList.size //single expression


    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView1: ImageView = itemView.image_view_1;
        val textView1: TextView = itemView.text_view_1;
        val textView2: TextView = itemView.text_view_2;

    }
}
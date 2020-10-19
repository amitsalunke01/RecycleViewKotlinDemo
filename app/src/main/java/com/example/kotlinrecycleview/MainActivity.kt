package com.example.kotlinrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val exampleItem = generateDummyData(100)
    private val adapter = ExampleAdapter(exampleItem)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycle_view.adapter = adapter
        recycle_view.layoutManager = LinearLayoutManager(this)
        recycle_view.setHasFixedSize(true)
    }

    fun insertItem(view: View) {

    }

    fun deleteItem(view: View) {

    }

    private fun generateDummyData(size: Int): List<ExampleItem> {
        val exampleList: ArrayList<ExampleItem> = ArrayList()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_audio
                else -> R.drawable.ic_sun
            }

            val item = ExampleItem(drawable, "Item $i", "Line2");
            //exampleList += item;
            exampleList.add(item)
        }
        return exampleList
    }
}
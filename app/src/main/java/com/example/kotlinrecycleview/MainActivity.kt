package com.example.kotlinrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val exampleItem = generateDummyData(100)

        recycle_view.adapter = ExampleAdapter(exampleItem)
        recycle_view.layoutManager = LinearLayoutManager(this)
        recycle_view.setHasFixedSize(true)
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
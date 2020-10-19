
package com.example.kotlinrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), ExampleAdapter.OnItemClickListener {
    private val exampleItem = generateDummyData(100)
    private val adapter = ExampleAdapter(exampleItem, this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycle_view.adapter = adapter
        recycle_view.layoutManager = LinearLayoutManager(this)
        recycle_view.setHasFixedSize(true)
    }

    fun insertItem(view: View) {
        val index = Random.nextInt(8) //0to8
        val newItem = ExampleItem(
            R.drawable.ic_sun,
            "New Item at $index",
            "Line 2"
        )

        exampleItem.add(index, newItem)
        adapter.notifyItemInserted(index)
    }

    fun deleteItem(view: View) {
        val index = Random.nextInt(8)
        exampleItem.removeAt(index)
        adapter.notifyItemRemoved(index)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = exampleItem[position]
        clickedItem.text1 = "clicked"
        adapter.notifyItemChanged(position)
    }

    private fun generateDummyData(size: Int): ArrayList<ExampleItem> {
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
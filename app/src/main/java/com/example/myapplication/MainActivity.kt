package com.example.myapplication

import android.content.Intent
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = mutableListOf<AnimalData>()

        val imgPathCat: String = "app/src/main/res/images/hippo.jpg"
        val imgPathDog: String = "app/src/main/res/images/capybara.jpg"
        val imgPathMouse: String = "app/src/main/res/images/whale.jpg"

        data.add(AnimalData("Капібара", " ", R.drawable.capybara, Color.BLACK, this.resources.getString(R.string.first_description)))
        data.add(AnimalData("Кит", " ", R.drawable.whale, Color.BLACK, this.resources.getString(R.string.second_description)))
        data.add(AnimalData("Бегемот", " ", R.drawable.hippo, Color.BLACK, this.resources.getString(R.string.third_description)))

        recyclerView.adapter = AnimalsRecyclerAdapter(data, this)
    }

    public fun startActivity(longDesc: String)
    {
        startActivity(Intent(this, SecondActivity::class.java).apply
        {
            putExtra("text", longDesc)
        })
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
    }
}
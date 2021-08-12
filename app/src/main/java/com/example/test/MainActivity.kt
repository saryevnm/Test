package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_item.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter()
        adapter.submitList(listOf(Person(23,23,"hen"),Person(43,53,"merila")))
        rv_item.adapter = adapter
        btn_add.setOnClickListener{
            adapter.submitList(listOf(Person(26,53,"chuk")))
        }
    }
}
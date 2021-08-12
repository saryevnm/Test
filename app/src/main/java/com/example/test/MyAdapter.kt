package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.view.*

class MyAdapter: RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    private  var oldPersonlist = emptyList<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        holder.onBind(oldPersonlist[position])
    }

    override fun getItemCount(): Int {
        return oldPersonlist.size
    }
    fun submitList(newList:List<Person>){
        val myDiff = MyDiffUtil(oldPersonlist,newList)
        val diffResult= DiffUtil.calculateDiff(myDiff,true)
        oldPersonlist = newList
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val v: View):RecyclerView.ViewHolder(v){
        fun onBind(person: Person) {
            v.age.text = person.age.toString()
            v.name.text = person.name
        }
    }
}